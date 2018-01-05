package com.okay.myapp.view;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/5 18:32
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyCustomLayout extends LinearLayout {

    private ViewDragHelper mDragger;

    private View mDragView;
    private View mAutoBackView;
    private View mEdgeTrackerView;

    private Point mAutoBackOriginPos = new Point();


    public MyCustomLayout(Context context) {
        super(context);
    }

    public MyCustomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


//        helper.mTouchSlop = (int) (helper.mTouchSlop * (1 / sensitivity));
        mDragger = ViewDragHelper.create(this, 1.0f,
                new ViewDragHelper.Callback() {

                    @Override
                    public boolean tryCaptureView(View child, int pointerId) {
                        //mEdgeTrackerView禁止直接移动
                        return child == mDragView || child == mAutoBackView;                    }

                    @Override
                    public int clampViewPositionHorizontal(View child, int left, int dx) {

                        return left;
                    }

                    @Override
                    public int clampViewPositionVertical(View child, int top, int dy) {
                        return top;
                    }
                    //手指释放的时候回调
                    @Override
                    public void onViewReleased(View releasedChild, float xvel, float yvel)
                    {
                        //mAutoBackView手指释放时可以自动回去
                        if (releasedChild == mAutoBackView)
                        {
                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                            invalidate();
                        }
                    }

                    //在边界拖动时回调
                    @Override
                    public void onEdgeDragStarted(int edgeFlags, int pointerId)
                    {
                        mDragger.captureChildView(mEdgeTrackerView, pointerId);
                    }
                });
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragger.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll()
    {
        if(mDragger.continueSettling(true))
        {
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);

        mAutoBackOriginPos.x = mAutoBackView.getLeft();
        mAutoBackOriginPos.y = mAutoBackView.getTop();
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        mDragView = getChildAt(0);
        mAutoBackView = getChildAt(1);
        mEdgeTrackerView = getChildAt(2);
    }
}
