package com.dream.java.base.operator;

/**
 * 移位操作符.
 * http://www.cnblogs.com/bluestorm/p/5795461.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-10-21
 * @phone 152-5320-8570
 */

public class TestShift {

    /**
     * 移位运算符操作的对象就是二进制的位，可以单独用移位运算符来处理int型整数.
     *
     * @param args
     */
    public static void main(String[] args) {
        testLeftShift();

        testRightShift();

        testNoRightShift();
    }

    /**
     * [<<	]左移运算符，将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）
     */
    private static void testLeftShift() {
        int x = 15, y = 2;
        int l = x << y;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(l));
        System.out.println("------------------------------");
    }

    /**
     * [>>	]"有符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数
     * 使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.
     */
    private static void testRightShift() {
        int x = 15, y = -15, z = 2;

        int r1 = x >> z;
        int r2 = y >> z;

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(r1));

        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(r2));
        System.out.println("------------------------------");
    }

    /**
     * [>>>]	"无符号"右移运算符，将运算符左边的对象向右移动运算符右边指定的位数
     * 采用0扩展机制，也就是说，无论值的正负，都在高位补0.
     */
    private static void testNoRightShift() {
        int x = 15, y = -15, z = 2;

        int r1 = x >>> z;
        int r2 = y >>> z;

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(r1));

        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(r2));
        System.out.println("------------------------------");
    }

}
