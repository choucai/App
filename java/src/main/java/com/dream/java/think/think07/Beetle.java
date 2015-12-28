package com.dream.java.think.think07;

/**
 * Created by William on 15/11/17.
 */
public class Beetle extends Insect {

    private int k = printInit("Beetle.k initialized");

    Beetle(){
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static Insect.x2 initialized");

}
