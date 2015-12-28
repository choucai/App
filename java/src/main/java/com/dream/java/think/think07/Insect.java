package com.dream.java.think.think07;

/**
 * Created by William on 15/11/17.
 */
public class Insect {

    private int i = 9;

    protected  int j = printInit("Beetle.j initialized");

    Insect(){
        System.out.println("i = " + i + ",j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s){
        System.out.println(s);
        return 47;
    }

}
