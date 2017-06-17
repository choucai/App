package com.dream.java.java8.date2time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * LocalTime.
 * http://www.liaoxuefeng.com/article/00141939241051502ada88137694b62bfe844cd79e12c32000
 * https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20%E6%96%B0%E7%9A%84%E6%97%B6%E9%97%B4%E6%97%A5%E6%9C%9F%E5%BA%93%E7%9A%8420%E4%B8%AA%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/13
 * @phone 152-5320-8570
 */
public class TestLocalTime {


    public static void main(String[] args) {

        testBase();

        testSix();

        testSeven();


    }

    /**
     * 示例-6 如何在Java 8中获取当前时间
     */
    private static void testSix() {
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);

        time = LocalTime.now().withNano(0);
        System.out.println("local time now : " + time);

        time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println("local time now : " + time);
    }

    /**
     * 示例-7 如何增加时间里面的小时数
     */
    private static void testSeven() {
        LocalTime time = LocalTime.now().withNano(0);
        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);
    }

    private static void testBase() {
        // LocalTime包含毫秒
        LocalTime now = LocalTime.now();
        System.out.println(now.toString());

        // 清除毫秒数
        now = LocalTime.now().withNano(0);
        System.out.println(now.toString());

        // 构造时间
        LocalTime zero = LocalTime.of(0, 0, 0);
        System.out.println(zero.toString());

        LocalTime mid = LocalTime.parse("12:00:00");
        System.out.println(mid.toString());
    }

}
