package com.dream.java.senior.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午5:09.
 * @phone 152-5320-8570
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface MethodInfo {

    String author() default "lijunbo@yyhudong.com";

    String date();

    int version() default 1;

}
