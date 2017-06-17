package com.dream.java.base.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 正则表达式.
 * http://www.runoob.com/java/java-regular-expressions.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/14
 * @phone 152-5320-8570
 */
public class RegularExpression {


    public static void main(String[] args) {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        if(m.find()){
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        }else {
            System.out.println("No Match !");
        }
    }

}
