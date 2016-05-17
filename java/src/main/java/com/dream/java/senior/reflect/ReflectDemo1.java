package com.dream.java.senior.reflect;

import com.dream.java.senior.reflect.entity.SonClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Java反射基础.
 * http://blog.csdn.net/My_TrueLove/article/details/51298218
 * http://blog.csdn.net/My_TrueLove/article/details/51306921
 *
 * @author 李君波
 * @version v1.0.0 2016-05-17 上午10:06.
 */
public class ReflectDemo1 {


    /**
     * 使用反射获取类的信息
     */
    public static void main(String[] args) {
        printFields();
        printMethods();
    }

    /**
     * 通过反射获取类的所有变量
     */
    private static void printFields() {
        // 1-获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的包名+名称---" + mClass.getName());
        System.out.println("类的名称-" + mClass.getSimpleName());
        System.out.println();

        // 2-1获取所有public访问权限的变量-【包括本类声明的和从父类继承的】
//        Field[] fields = mClass.getFields();

        // 2-2【获取所有本类声明的变量（不问访问权限）】
        Field[] fields = mClass.getDeclaredFields();

        // 3-遍历变量并输出变量信息
        for (Field field : fields) {

            // 获取访问权限
            int modifiers = field.getModifiers();
            String fieldModify = Modifier.toString(modifiers);
            System.out.println("访问权限---" + fieldModify);

            // 获取变量的类型
            String fieldType = field.getType().getSimpleName();
            System.out.println("变量类型---" + fieldType);

            // 获取变量名
            String fieldName = field.getName();
            System.out.println("变量名称---" + fieldName);
            System.out.println();

        }
    }

    /**
     * 通过反射获取类的所有方法
     */
    private static void printMethods() {
        // 1-获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的包名+名称---" + mClass.getName());
        System.out.println("类的名称-" + mClass.getSimpleName());
        System.out.println();

        // 2-1 获取所有public访问权限的方法
//        Method[] methods = mClass.getMethods();

        // 2-2 获取所有本类的方法(不问访问权限)
        Method[] methods = mClass.getDeclaredMethods();

        // 3- 遍历所有方法

        for (Method method : methods) {
            // 获取方法的访问权限(Modifiers:修饰符)
            int modifiers = method.getModifiers();
            String methodModify = Modifier.toString(modifiers);
            System.out.println("返回权限---" + methodModify);

            // 获取方法的返回值类型
            String methodType = method.getReturnType().getSimpleName();
            System.out.println("返回类型---" + methodType);

            // 获取方法的名称
            String methodName = method.getName();
            System.out.println("方法名称---" + methodName);

            // 获取方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("参数类型---" + parameter.getType().getSimpleName() + " | 参数名称" + parameter.getName());
            }

            // 获取方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if(exceptionTypes.length == 0){
                System.out.println("此方法没有异常");
            }else {
                for(Class c : exceptionTypes){
                    System.out.println(c.getSimpleName());
                }
            }
            System.out.println();

        }

    }


}
