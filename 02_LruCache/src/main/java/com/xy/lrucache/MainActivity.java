package com.xy.lrucache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.xy.lrucache.utils.BitmapLruCache;
import com.xy.lrucache.utils.BitmapUtils;

/**
 * LruCache Study : https://blog.csdn.net/guolin_blog/article/details/9316683
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Context ctx;
    private ImageView imageView;
    private BitmapLruCache bitmapLruCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        testLruCache();
        testBitmapCache();
    }

    private void initData() {
        bitmapLruCache = new BitmapLruCache();
    }

    private void testLruCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);

        Log.d(TAG," maxMemory = "+maxMemory/1024+"M");

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.mipmap.image1,options);

        getBitmapParams(options,"图片压缩前属性------");

        Bitmap bitmap = BitmapUtils.decodeSampleBitmapFromResource(getResources(), R.mipmap.image1, 128, 96);

        imageView.setImageBitmap(bitmap);
    }


    private void testBitmapCache() {

        loadBitmap(R.mipmap.image1, imageView);

    }

    private void loadBitmap(int resId, ImageView imageView) {

        String key = String.valueOf(resId);

        Bitmap bitmap = bitmapLruCache.getBitmapFromMemoryCache(key);
        if (bitmap == null) {
            new DownLoadImageTask(imageView).execute(R.mipmap.image1);
        } else {
            imageView.setImageBitmap(bitmap);
        }

    }


    private void initView() {

        imageView = findViewById(R.id.imageview);

    }

    class DownLoadImageTask extends AsyncTask<Integer, Void, Bitmap> {


        private ImageView imageView;

        public DownLoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {

            Bitmap bitmap = BitmapUtils.decodeSampleBitmapFromResource(getResources(), params[0], 100, 100);

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private void getBitmapParams(BitmapFactory.Options options,String text) {
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;
        String outMimeType = options.outMimeType;

        Log.d(TAG, text);
        Log.d(TAG, "onCreate:  outWidth = "+outWidth);
        Log.d(TAG, "onCreate:  outHeight =  "+outHeight);
        Log.d(TAG, "onCreate:  outMimeType "+outMimeType);
    }

}
