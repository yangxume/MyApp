package com.okay.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.okay.myapp.utils.LogUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 10:51
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description image 相关
 * <p>
 * Update records:
 */

public class Activity10_AboutImage extends BaseActivity {


    private static final String TAG = Activity10_AboutImage.class.getSimpleName();
    @BindView(R.id.et_quality)
    EditText etQuality;
    @BindView(R.id.btn1_test_quality_compress)
    Button btn1TestQualityCompress;
    @BindView(R.id.et_inSampleSize)
    EditText etInSampleSize;
    @BindView(R.id.btn2_test_insamplesize_compress)
    Button btn2TestInsamplesizeCompress;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.btn3_test_matrix)
    Button btn3TestMatrix;

    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity10_about_image);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image_2m);

        LogUtils.d("xuyang", "压缩前图片的大小" + (bitmap.getByteCount() / 1024 / 1024)
                + "M宽度为" + bitmap.getWidth() + "高度为" + bitmap.getHeight());
    }

    @OnClick({
            R.id.btn1_test_quality_compress,
            R.id.btn2_test_insamplesize_compress,
            R.id.btn3_test_matrix
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn1_test_quality_compress:
                int quality = Integer.valueOf(etQuality.getText().toString().trim());
                testQualityCompress(bitmap, quality);

                break;

            case R.id.btn2_test_insamplesize_compress:
                int inSampleSize = Integer.valueOf(etInSampleSize.getText().toString().trim());
                testInSampleSizeCompress(bitmap, inSampleSize);

                break;

            case R.id.btn3_test_matrix:
                testMatrixCompress(bitmap);
                break;


        }
    }

    /**
     * 1.质量压缩
     *
     * @param bit
     * @param quality
     */
    private void testQualityCompress(Bitmap bit, int quality) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bit.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        byte[] bytes = baos.toByteArray();
        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        Log.i("xuyang", "质量压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M 宽度为" + bm.getWidth() + " 高度为" + bm.getHeight()
                + "bytes.length= " + (bytes.length / 1024) + "KB "
                + "quality=" + quality);
        iv.setImageBitmap(bm);


        /**
         图片的大小是没有变的，因为质量压缩不会减少图片的像素，
         它是在保持像素的前提下改变图片的位深及透明度等，来达到压缩图片的目的，
         这也是为什么该方法叫质量压缩方法。那么，图片的长，宽，像素都不变，那么bitmap所占内存大小是不会变的。

         但是我们看到bytes.length是随着quality变小而变小的。
         这样适合去传递二进制的图片数据，比如微信分享图片，要传入二进制数据过去，限制32kb之内
         */

//        03-09 10:52:22.980 3774-3774/com.okay.myapp D/xuyang: 压缩前图片的大小7M宽度为1632高度为1224
//        03-09 10:52:32.766 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 1213KB quality=100
//        03-09 10:52:43.044 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 334KB quality=90
//        03-09 10:52:53.867 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 96KB quality=50
//        03-09 10:52:59.775 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 28KB quality=10
//        03-09 10:53:04.395 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 14KB quality=1
//        03-09 10:53:09.157 3774-3774/com.okay.myapp I/xuyang: 压缩后图片的大小7M 宽度为1632 高度为1224bytes.length= 14KB quality=0
    }

    /**
     * 2.采样率压缩
     *
     * @param bit
     * @param inSampleSize
     */
    public void testInSampleSizeCompress(Bitmap bit, int inSampleSize) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream isBm = new ByteArrayInputStream(bytes);
        Bitmap bm = BitmapFactory.decodeStream(isBm, null, options);

        LogUtils.d("xuyangt", "采样率压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M 宽度为" + bm.getWidth() + "高度为" + bm.getHeight());

        iv.setImageBitmap(bm);

        /**
         设置inSampleSize的值(int类型)后，假如设为2，则宽和高都为原来的1/2，宽高都减少了，自然内存也降低了。

         我上面的代码没用过options.inJustDecodeBounds = true;
         因为我是固定来取样的数据，为什么这个压缩方法叫采样率压缩，
         是因为配合inJustDecodeBounds，先获取图片的宽、高【这个过程就是取样】，然后通过获取的宽高，动态的设置inSampleSize的值。

         当inJustDecodeBounds设置为true的时候，
         BitmapFactory通过decodeResource或者decodeFile解码图片时，
         将会返回空(null)的Bitmap对象，这样可以避免Bitmap的内存分配，但是它可以返回Bitmap的宽度、高度以及MimeType。

         */


    }

    /**
     * @param bit
     */
    public void testMatrixCompress(Bitmap bit) {

        /**
         * 缩放压缩
         */
//        Matrix matrix = new Matrix();
//        matrix.setScale(0.5f, 0.5f);
//        Bitmap bm = Bitmap.createBitmap(bit, 0, 0, bit.getWidth(),
//                bit.getHeight(), matrix, true);
//        Log.i("xuyang", "缩放压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
//                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight());

        /**
         * RGB_565压缩
         */
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inPreferredConfig = Bitmap.Config.RGB_565;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream isBm = new ByteArrayInputStream(bytes);
        Bitmap bm = BitmapFactory.decodeStream(isBm, null, options2);

        Log.i("xuyang", "RGB_565压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight());

        iv.setImageBitmap(bm);

//        我们看到图片大小直接缩小了一半，长度和宽度也没有变，相比argb_8888减少了一半的内存。
//
//        注意：由于ARGB_4444的画质惨不忍睹，一般假如对图片没有透明度要求的话，可以改成RGB_565，相比ARGB_8888将节省一半的内存开销。
    }


}
