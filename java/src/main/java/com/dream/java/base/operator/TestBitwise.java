package com.dream.java.base.operator;

/**
 * 位运算符.
 * http://www.cnblogs.com/bluestorm/p/5795461.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-10-20
 * @phone 152-5320-8570
 */

public class TestBitwise {

    public static void main(String[] args) {

        testAnd();

        testOr();

        testNot();

        testXor();
    }

    /**
     * 【与】运算符
     * <p>
     * 与运算符用符号“&”表示，其运算规律是：两个操作数中位都为1，结果才为1，否则结果为0
     */
    private static void testAnd() {
        int a = 129; // 1000 0001
        int b = 128; // 1000 0000
        int c = a & b;

        System.out.println("a 是：" + Integer.toBinaryString(a));
        System.out.println("b 是：" + Integer.toBinaryString(b));
        System.out.println("c 是：" + Integer.toBinaryString(c));
        System.out.println("---------------");
    }

    /**
     * 【或】运算符
     * <p>
     * 或运算符用符号“|”表示，其运算规律是：两个位只要有一个为1，那么结果就是1，否则就为0
     */
    private static void testOr() {
        int a = 129; // 1000 0001
        int b = 128; // 1000 0000
        int c = a | b;

        System.out.println("a 是：" + Integer.toBinaryString(a));
        System.out.println("b 是：" + Integer.toBinaryString(b));
        System.out.println("c 是：" + Integer.toBinaryString(c));
        System.out.println("---------------");
    }

    /**
     * 【非】运算符
     * <p>
     * 非运算符用符号“~”表示，其运算规律是：如果位为0，结果是1，如果位为1，结果是0
     */
    private static void testNot() {
        int a = 2;
        int b = ~a;

        System.out.println("a 是：" + Integer.toBinaryString(a)); // 32位 【10】
        System.out.println("b 是：" + Integer.toBinaryString(b)); // 32位 【11111111111111111111111111111101】
        System.out.println("---------------");
    }

    /**
     * 【异或】运算符
     * <p>
     * 异或运算符是用符号“^”表示的，其运算规律是：两个操作数的位中，相同则结果为0，不同则结果为1
     */
    private static void testXor() {
        int a = 15;
        int b = 2;
        int c = a^b;
        System.out.println("a 是：" + Integer.toBinaryString(a)); // 32位 【1111】
        System.out.println("b 是：" + Integer.toBinaryString(b)); // 32位【0010】
        System.out.println("b 是：" + Integer.toBinaryString(c)); // 32位 【1101】
        System.out.println("---------------");
    }

}
