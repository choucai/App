package com.dream.java.java8.date2time;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * LocalDate.
 * http://www.liaoxuefeng.com/article/00141939241051502ada88137694b62bfe844cd79e12c32000
 * https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20%E6%96%B0%E7%9A%84%E6%97%B6%E9%97%B4%E6%97%A5%E6%9C%9F%E5%BA%93%E7%9A%8420%E4%B8%AA%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/13
 * @phone 152-5320-8570
 */
public class TestLocalDate {

    public static void main(String[] args) {

//        testBase();

//        testOne();

//        testTwo();

//        testThree();

//        testFour();

//        testFive();

//        testEight();

//        testNine();

//        testTen();

//        testEleven();

//        testThirteen();

//        testFourteen();

//        testFifteen();

//        testSixteen();

//        testSeventeen();

//        testEighteen();

//        testNinteen();

        testTwenty();

    }


    /**
     * 示例-20 如何在Java 8中对日期进行格式化，转换成字符串
     */
    private static void testTwenty() {
        LocalDateTime arrivalDate = LocalDateTime.now();

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }


    /**
     * 示例-19 如何在Java中使用自定义的格式器来解析日期
     */
    private static void testNinteen() {
        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }
    }


    /**
     * 示例-18 如何在Java 8中使用预定义的格式器来对日期进行解析/格式化
     */
    private static void testEighteen() {
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
    }


    /**
     * 示例-17 在Java 8中如何获取当前时间戳
     * <p>
     * 当前时间戳是包含日期与时间的，与java.util.Date很类似，事实上Instant就是Java 8前的Date
     * 你可以使用这两个类中的方法来在这两个类型之间进行转换
     * 比如Date.from(Instant)是用来将Instant转换成java.util.Date的
     * 而Date.toInstant()是将Date转换成Instant的
     */
    private static void testSeventeen() {
        Instant timestamp = Instant.now();

        System.out.println("What is value of this instant " + timestamp);

        Date date = new Date();
        timestamp = date.toInstant();
        System.out.println("What is value of this instant " + timestamp);

        date = date.from(timestamp);
        System.out.println("What is value of this instant " + date);
    }


    /**
     * 示例-16 带时区偏移量的日期与时间
     * <p>
     * 在Java 8里面，你可以用ZoneOffset类来代表某个时区，比如印度是GMT或者UTC5：30
     * 你可以使用它的静态方法ZoneOffset.of()方法来获取对应的时区
     * 只要获取到了这个偏移量，你就可以拿LocalDateTime和这个偏移量创建出一个OffsetDateTime
     */
    private static void testSixteen() {
        LocalDateTime datetime = LocalDateTime.of(2016, Month.SEPTEMBER, 13, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");

        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }


    /**
     * 示例-15 两个日期之间包含多少天，多少个月
     * <p>
     * 还有一个常见的任务就是计算两个给定的日期之间包含多少天，多少周或者多少年
     * 你可以用java.time.Period类来完成这个功能
     */
    private static void testFifteen() {
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2015, Month.SEPTEMBER, 12);

        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getYears());
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getDays());
    }


    /**
     * 示例-14 如何在Java 8中检查闰年
     * <p>
     * 这并没什么复杂的，LocalDate类有一个isLeapYear()的方法能够返回当前LocalDate对应的那年是否是闰年
     */
    private static void testFourteen() {
        LocalDate today = LocalDate.now();

        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("2016 is not a Leap year");
        }
    }


    /**
     * 示例-13 如何表示固定的日期，比如信用卡过期时间
     * <p>
     * 正如MonthDay表示的是某个重复出现的日子的，YearMonth又是另一个组合
     * 它代表的是像信用卡还款日，定期存款到期日，options到期日这类的日期
     * <p>
     * 你可以用这个类来找出那个月有多少天
     * lengthOfMonth()这个方法返回的是这个YearMonth实例有多少天
     * 这对于检查2月到底是28天还是29天可是非常有用的
     */
    private static void testThirteen() {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }


    /**
     * 示例-11 在Java中如何判断某个日期是在另一个日期的前面还是后面
     */
    private static void testEleven() {
        LocalDate today = LocalDate.now();

        LocalDate tommorow = today.plus(1, ChronoUnit.DAYS);
        if (tommorow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }

        if (today.equals(LocalDate.now())) {
            System.out.println("today is today");
        }
    }


    /**
     * 示例-10 在Java 8中使用时钟
     * <p>
     * Java 8中自带了一个Clock类，你可以用它来获取某个时区下当前的瞬时时间，日期或者时间
     * 可以用Clock来替代System.currentTimeInMillis()与 TimeZone.getDefault()方法。
     */
    private static void testTen() {
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // Returns time based on system clock zone Clock defaultClock =
        Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);
    }


    /**
     * 示例-9 一年前后的日期
     */
    private static void testNine() {
        LocalDate today = LocalDate.now();

        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }


    /**
     * 示例-8 如何获取1周后的日期
     * <p>
     * 可以用这个方法来增加一个月，一年，一小时，一分钟，甚至是十年
     * 查看下Java API中的ChronoUnit类来获取更多选项
     */
    private static void testEight() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);

        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }


    /**
     * 示例-5 在Java 8中如何检查重复事件，比如说生日
     * <p>
     * 在Java中还有一个与时间日期相关的实际任务就是检查重复事件
     * 比如说每月的帐单日，结婚纪念日，每月还款日或者是每年交保险费的日子
     * 如果你在一家电商公司工作的话，那么肯定会有这么一个模块
     * 会去给用户发送生日祝福并且在每一个重要的假日给他们捎去问候，比如说圣诞节，感恩节，在印度则可能是万灯节（Deepawali）
     * 如何在Java中判断是否是某个节日或者重复事件？使用MonthDay类
     * 这个类由月日组合，不包含年信息，也就是说你可以用它来代表每年重复出现的一些日子
     * 当然也有一些别的组合，比如说YearMonth类
     * 它和新的时间日期库中的其它类一样也都是不可变且线程安全的，并且它还是一个值类（value class）
     */
    private static void testFive() {
        LocalDate dateOfBirth = LocalDate.of(2016, 9, 13);

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());

        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }

    }


    /**
     * 示例4 在Java 8中如何检查两个日期是否相等
     * <p>
     * 如果说起现实中实际的处理时间及日期的任务，有一个常见的就是要检查两个日期是否相等
     * 你可能经常会碰到要判断今天是不是某个特殊的日子，比如生日啊，周年纪念日啊，或者假期之类
     * 有的时候，会给你一个日期，让你检查它是不是某个日子比方说假日
     */
    private static void testFour() {
        LocalDate birthday = LocalDate.of(2014, 01, 14);
        LocalDate today = LocalDate.now();
        if (birthday.equals(today)) {
            System.out.printf("Today %s and birthday %s are same date %n", today, birthday);
        }
    }


    /**
     * 示例3 在Java 8中如何获取某个特定的日期
     * <p>
     * 在第一个例子中，我们看到通过静态方法now()来生成当天日期是非常简单的
     * 不过通过另一个十分有用的工厂方法LocalDate.of()，则可以创建出任意一个日期
     * 它接受年月日的参数，然后返回一个等价的LocalDate实例
     * 关于这个方法还有一个好消息就是它没有再犯之前API中的错，比方说，年只能从1900年开始，月必须从0开始，等等。
     */
    private static void testThree() {
        LocalDate dateOfBirth = LocalDate.of(2012, 01, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);
    }


    /**
     * 示例2 如何在Java 8中获取当前的年月日
     * LocalDate类中提供了一些很方便的方法可以用于提取出年月日以及其它的日期属性
     * 使用这些方法，你可以获取到任何你所需要的日期属性，而不再需要使用java.util.Calendar这样的类了
     */
    private static void testTwo() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }


    /**
     * 示例1 如何 在Java 8中获取当天的日期
     * <p>
     * Java 8中有一个叫LocalDate的类，它能用来表示今天的日期
     * 这个类与java.util.Date略有不同，因为它只包含日期，没有时间
     * 因此，如果你只需要表示日期而不包含时间，就可以使用它
     */
    private static void testOne() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);
    }


    private static void testBase() {
        // 取当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());

        // 根据年月日取日期
        LocalDate crischristmas = LocalDate.of(2016, 2, 25);
        System.out.println(crischristmas.toString());

        // 根据字符串取日期
        LocalDate strDate = LocalDate.parse("2016-09-01");// 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        System.out.println(strDate.toString());

        // LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth.toString());

        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println(secondDayOfThisMonth.toString());

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth.toString());

        // 取下一天：
        LocalDate firstDayOf2016 = lastDayOfThisMonth.plusDays(1);
        System.out.println(firstDayOf2016.toString());

        // 取2016年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2016 = LocalDate.parse("2016-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOf2016.toString());
    }


}
