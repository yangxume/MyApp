package com.xy.interview.interface_abstract_sense;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/27 16:49
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description 接口回调测试
 * <p>
 * Update records:
 */

public class TestInterfCallBack  {

    public static void main(String [] args){

        InterfCallBack interfCallBack = new InterfCallBack();
        interfCallBack.setOnClickListener(new InterfCallBack.onClickListener() {
            @Override
            public void onClick(String msg) {
                System.out.println(msg);
            }
        });

    }

}
