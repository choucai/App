package com.dream.java.senior.reflect.entity;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-05-17 上午10:44.
 */
public class SonClass extends FatherClass{

    private String mSonName;

    protected int mSonAge;

    public String mSonBirthday;

    public void printSonMsg(){
        System.out.println("Son Msg - name : " + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name){
        mSonName = name;
    }

    private void setSonAge(int age){
        mSonAge = age;
    }

    private int getSonAge(){
        return mSonAge;
    }

    private String getSonName(){
        return mSonName;
    }
}
