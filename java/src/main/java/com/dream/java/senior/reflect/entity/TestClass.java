package com.dream.java.senior.reflect.entity;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0 2016-05-17 下午2:55.
 */
public class TestClass {

    //String 会被 JVM 优化
//    private final String FINAL_VALUE = "FINAL";
    private final String FINAL_VALUE;

    public TestClass() {
        FINAL_VALUE = "FINAL";
    }

    public String getFinalValue(){
        //会被优化为: return "FINAL" ,拭目以待吧
        return FINAL_VALUE;
    }

    private String MSG = "Original";

    private void privateMethod(String head , int tail){
        System.out.println(head + " --- " +tail);
    }

    public String getMsg(){
        return MSG;
    }

}
