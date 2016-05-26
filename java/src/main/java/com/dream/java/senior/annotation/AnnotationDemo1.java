package com.dream.java.senior.annotation;

import java.lang.reflect.Method;

/**
 * 能够添加到 Java 源代码的语法元数据。类、方法、变量、参数、包都可以被注解，可用来将信息元数据与程序元素进行关联。Annotation 中文常译为“注解”.
 *http://p.codekk.com/blogs/detail/54cfab086c4761e5001b253b
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午4:54.
 * @phone 152-5320-8570
 */
public class AnnotationDemo1 {


    public static void main(String[] args) {
        runTimeParse();
    }

    /**
     * 运行时 Annotation 解析
     */
    private static void runTimeParse() {
        try {
            Class cls = Class.forName("com.dream.java.senior.annotation.App");
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if (methodInfo != null) {
                    System.out.println("method name:" + method.getName());
                    System.out.println("method author:" + methodInfo.author());
                    System.out.println("method version:" + methodInfo.version());
                    System.out.println("method date:" + methodInfo.date());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     * 编译时 Annotation 解析
     */


}
