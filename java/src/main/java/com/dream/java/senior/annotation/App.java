package com.dream.java.senior.annotation;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午5:11.
 * @phone 152-5320-8570
 */
public class App {

    @MethodInfo(
            author = "William",
            date = "2016-05-26",
            version = 2
    )
    public String getAppName(){
        return "William";
    }


}
