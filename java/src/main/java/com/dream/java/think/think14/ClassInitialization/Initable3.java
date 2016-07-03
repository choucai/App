package com.dream.java.think.think14.classInitialization;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-03 下午12:01.
 */
public class Initable3 {

    public static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }

}
