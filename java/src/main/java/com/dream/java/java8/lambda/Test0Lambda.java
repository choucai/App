package com.dream.java.java8.lambda;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Java 8新特性探究（一）通往lambda之路_语法篇.
 * https://my.oschina.net/benhaile/blog/175012
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/14
 * @phone 152-5320-8570
 */
public class Test0Lambda {


    public static void main(String[] args) {
        // Lambda语法 (parameters) -> expression 或者 (parameters) -> { statements; }
        testUseLambda();

        // 方法引用 ObjectReference::methodName
        testUseLambdaMethod();


        //

        //
    }


    /**
     * 方法引用.
     * ObjectReference::methodName
     * 一般方法的引用格式是
     * <p>
     * 如果是静态方法，则是ClassName::methodName。如 Object ::equals
     * <p>
     * 如果是实例方法，则是Instance::methodName。如Object obj=new Object();obj::equals;
     * <p>
     * 构造函数.则是ClassName::new
     */
    private static void testUseLambdaMethod() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        JButton button1 = new JButton("点我!");
        JButton button2 = new JButton("也点我!");
        JButton button3 = new JButton("后点我!");

        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);

        //这里addActionListener方法的参数是ActionListener，是一个函数式接口使用lambda表达式方式
        button1.addActionListener(e -> System.out.println("这里是Lambda实现方式"));

        //①使用【静态方法】引用方式
        button2.addActionListener(Test0Lambda::doSomething);

        // ②使用【实例方法】引用方式
        DoSome doSome = new DoSome();
        button3.addActionListener(doSome::doSomething);

        // ③使用【构造方法】引用方式
        new Thread(Runnabler::new).start();
    }

    /**
     * Lambda语法 - 包含三个部分
     * 一个括号内用逗号分隔的形式参数，参数是函数式接口里面方法的参数
     * 一个箭头符号：->
     * 方法体，可以是表达式和代码块，方法体函数式接口里面方法的实现
     * 如果是代码块，则必须用 { } 来包裹起来，且需要一个return 返回值
     * 但有个例外，若函数式接口里面方法返回值是void，则无需 { }
     */
    public static void testUseLambda() {
        // Runnable是一个函数接口，只包含了有个无参数的，返回void的run方法
        // 所以lambda表达式左边没有参数，右边也没有return，只是单纯的打印一句话
        new Thread(() -> System.out.println("lambda实现的线程")).start();


        // 这种方式就不多讲了，以前旧版本比较常见的做法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }

    /**
     * 这里是函数式接口ActionListener的实现方法
     *
     * @param e
     */
    public static void doSomething(ActionEvent e) {
        System.out.println("这里是方法引用实现方式");
    }

    private static class DoSome {
        public void doSomething(ActionEvent e) {
            System.out.println("这里引用实例方法实现方式");
        }
    }

    private static class Runnabler implements Runnable {

        @Override
        public void run() {
            System.out.println("使用实例构造方法引用方式");
        }
    }

}
