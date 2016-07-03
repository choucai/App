package com.dream.java.think.think14.classInitialization;

import java.util.Random;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-03 下午12:03.
 */
public class ClassInitialization {

    public static final Random rand = new Random(47);

    public static void main(String[] args) throws Exception {

        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        // Does not trigger initialization:
        System.out.println(Initable.staticFinal);
        // Does trigger initialization:
        System.out.println(Initable.staticFinal2);

        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);

        Class initable3 = Class.forName("com.dream.java.think.think14.classInitialization.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }

}
