package com.dream.java.rx.test.C.entity;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/4
 * @phone 152-5320-8570
 */
public class Indexed <T> {

    public final int index;

    public final T item;

    public Indexed(int index, T item) {
        this.index = index;
        this.item = item;
    }

}
