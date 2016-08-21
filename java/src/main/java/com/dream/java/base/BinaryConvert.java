package com.dream.java.base;

/**
 * 进制以及进制之间的转换.
 * http://jingyan.baidu.com/article/495ba84109665338b30ede98.html
 * http://jingyan.baidu.com/article/47a29f24292608c0142399cb.html
 * http://www.cnblogs.com/icerainsoft/archive/2012/08/06/2624790.html
 * 打印ASCII表与进制对照表
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/21
 * @phone 152-5320-8570
 */
public class BinaryConvert {


    public static void main(String[] args) {
        System.out.println("10 to 2" + Integer.toBinaryString(120));
        System.out.println("10 to 8" + Integer.toOctalString(120));
        System.out.println("10 to 16" + Integer.toHexString(120));

        System.out.println("2 to 10" + Integer.valueOf("1010", 2));
        System.out.println("8 to 10" + Integer.valueOf("125", 8));
        System.out.println("16 to 10" + Integer.valueOf("A", 16));
    }


}
