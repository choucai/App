package com.dream.java.think.think14.classInitialization;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-03 下午12:02.
 */
public class Initable2 {

    public static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }

}
