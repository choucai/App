package com.dream.java.senior.reflect.entity;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午3:44.
 * @phone 152-5320-8570
 */
public class Person {
    String mName;

    public Person(String aName) {
        mName = aName;
    }

    private void sayHello(String friendName) {
        System.out.println(mName + " say hello to " + friendName);
    }

    protected void showMyName() {
        System.out.println("My name is " + mName);
    }

    public void breathe() {
        System.out.println(" take breathe ");
    }


    @Override
    public String toString() {
        return "My name is " + (null == mName ? "null" : mName);
    }
}
