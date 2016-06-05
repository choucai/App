package com.dream.java.senior.generics;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Type详解.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/6/5
 * @phone 152-5320-8570
 */
public class TestType2<K extends Comparable & Serializable, V> {

    K key;
    V value;

    public static void main(String[] args) throws Exception {
        // 获取字段的类型
        Field fk = TestType2.class.getDeclaredField("key");
        Field fv = TestType2.class.getDeclaredField("value");

//        Assert.that(fk.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");
//        Assert.that(fv.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");


        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();

        // getName 方法
        System.out.println(keyType.getName());                 // K
        System.out.println(valueType.getName());               // V

        // getGenericDeclaration 方法
        System.out.println(keyType.getGenericDeclaration());   // class com.test.TestType2
        System.out.println(valueType.getGenericDeclaration()); // class com.test.TestType2

        // getBounds 方法
        System.out.println("K 的上界:");                        // 有两个
        for (Type type : keyType.getBounds()) {                // interface java.lang.Comparable
            System.out.println(type);                          // interface java.io.Serializable
        }

        System.out.println("V 的上界:");                        // 没明确声明上界的, 默认上界是 Object
        for (Type type : valueType.getBounds()) {              // class java.lang.Object
            System.out.println(type);
        }
    }

}
