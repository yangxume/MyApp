package com.xy.interview.inner_class;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/27 17:03
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class OuterClass {

    private static int i = 1;
    private int j = 20;
    private int k = 30;

    public static void outer_f1() {

    }

    public static void outer_f2() {

    }

    public void callInnerMethod(){

        Innter innter = new Innter();
        innter.inner_f1();

    }

    class Innter {

//        static int n = 4;  inner class cannot have a static declarations

        int j = 55;

        int inner_i = 100;

        void inner_f1() {

            outer_f1();
            outer_f2();

            System.out.println(i);
            System.out.println(OuterClass.this.j);
            System.out.println(j);
            System.out.println(inner_i);

        }


    }

}
