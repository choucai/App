package com.dream.java.base;

/**
 * 8种基本类型.
 * http://www.runoob.com/java/java-basic-datatypes.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/21
 * @phone 152-5320-8570
 */
public class BaseType {


    public static void main(String[] args) {

        // byte
        System.out.println("BaseType: [byte] binary num " + Byte.SIZE);
        System.out.println("Wrapper Class:" + Byte.class.getName());
        System.out.println("Min Value:Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("Max Value:Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("BaseType:[short] binary num:" + Short.SIZE);
        System.out.println("Wrapper Class:" + Short.class.getName());
        System.out.println("Min Value:Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("Max Value:Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("BaseType:[int] binary num:" + Integer.SIZE);
        System.out.println("Wrapper Class:" + Integer.class.getName());
        System.out.println("Min Value:Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("Max Value:Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("BaseType:[long] binary num:" + Long.SIZE);
        System.out.println("Wrapper Class:" + Long.class.getName());
        System.out.println("Min Value:Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("Max Value:Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("BaseType:[float] binary num:" + Float.SIZE);
        System.out.println("Wrapper Class:" + Float.class.getName());
        System.out.println("Min Value:Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("Max Value:Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("BaseType:[double] binary num:" + Double.SIZE);
        System.out.println("Wrapper Class:" + Double.class.getName());
        System.out.println("Min Value:Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("Max Value:Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("BaseType:[char] binary num:" + Character.SIZE);
        System.out.println("Wrapper Class:" + Character.class.getName());
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("Min Value:Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("Max Value:Character.MAX_VALUE=" + (int) Character.MAX_VALUE);
    }

}
