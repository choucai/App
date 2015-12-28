package com.dream.java.think.think05;

/**
 * Java中对象的finalize方法的使用.
 *
 * @author 李君波
 * @version v1.0.0
 * @date 2015-11-16
 */
public class TerminationCondition {

    public static void main(String[] args){
        Book novel = new Book(true);
        novel.checkIn(); // 及时将书签入

        new Book(true);// 故意将书签入,没有强引用,导致能及时GC
        System.gc();// 建议虚拟机进行垃圾回收
    }

}
