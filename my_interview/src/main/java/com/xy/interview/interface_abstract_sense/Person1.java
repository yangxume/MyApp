package com.xy.interview.interface_abstract_sense;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/27 16:28
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Person1 extends AbstractPerson1 implements PersonInterf {

    @Override
    public void say() {
        System.out.println("person1 say");
    }

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }
}
