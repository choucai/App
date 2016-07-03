package com.dream.java.think.think14.classInitialization;


/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-03 下午12:02.
 */
public class Initable {

    public static final int staticFinal = 47;

//    public static final int staticFinal2 = 48;

    public static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }

}
