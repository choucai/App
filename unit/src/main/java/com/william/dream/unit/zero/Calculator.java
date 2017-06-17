package com.william.dream.unit.zero;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/3
 * @phone 152-5320-8570
 */
public class Calculator {


    public int add(int one, int another) {
        // 为了简单起见，暂不考虑溢出等情况。
        return one + another;
    }


    public int multiply(int one, int another) {
        // 为了简单起见，暂不考虑溢出等情况。
        return one * another;
    }


    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");
        return divident / dividor;
    }

}
