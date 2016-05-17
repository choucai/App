package com.dream.java.senior.reflect;

/**
 * 浅谈 Java 中的 Class 类.
 * http://blog.csdn.net/my_truelove/article/details/51289217
 * <p/>
 * 理解java.lang.Class类
 * http://blog.csdn.net/bingduanlbd/article/details/8424243/
 *
 * @author 李君波
 * @version v1.0.0 2016-05-17 上午9:10.
 */
public class ClassDemo {

    public void toPrint(){
        System.out.println(ClassDemo.class.getSimpleName());
    }

    public ClassDemo(){

    }

    public ClassDemo(String dream){

    }

    public static void main(String[] args) {

        ClassDemo classDemo = new ClassDemo();

        // 得到类对象
        // TODO 1- 每个类都有一个隐含的静态成员class,所以可以通过类的静态成员表示
        Class c1 = ClassDemo.class;

        // TODO 2- 通过类对象的 getClass() 方法。由1不难理解，既然存在静态变量，那么通过对象的 getter 方法，就可以获取静态成员class
        Class c2 = classDemo.getClass();

        // TODO 3- 通过 Class 类的静态方法 forName() 方法获取 Class 的对象
        try {
            Class c3 = Class.forName("com.dream.java.senior.reflect.ClassDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * TODO 由Class类的对象得到类的对象
         * 我们可以通过类或类对象得到 Class 类的对象，反过来，我们也可以由 Class 类的对象得到类的对象
         * 需要提醒您的是：c2.newInstance() 需要调用 ClassDemo 类的无参构造方法
         *  如果 ClassDemo 类中存在显示的有参构造方法，会覆盖默认的无参构造方法
         *  同时又没有显示的声明无参构造方法，那么执行这段代码时会直接导致程序Crash掉
         */
        try {
            classDemo = (ClassDemo) c2.newInstance();
            classDemo.toPrint();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
