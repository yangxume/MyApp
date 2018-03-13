package com.xy.interview.interface_abstract_sense;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/27 16:45
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class InterfCallBack {


    private onClickListener onClickListener;

    public InterfCallBack.onClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(InterfCallBack.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void testClick(boolean isClicked){

        if (isClicked)
            onClickListener.onClick("我被点击了");

    }

    interface onClickListener{
        void onClick(String msg);
    }

}
