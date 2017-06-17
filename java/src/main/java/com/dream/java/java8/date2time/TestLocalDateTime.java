package com.dream.java.java8.date2time;

import org.junit.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * LocalDateTime.
 * http://www.importnew.com/9635.html
 * https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20%E6%96%B0%E7%9A%84%E6%97%B6%E9%97%B4%E6%97%A5%E6%9C%9F%E5%BA%93%E7%9A%8420%E4%B8%AA%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B.html
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/9/13
 * @phone 152-5320-8570
 */
public class TestLocalDateTime {


    public static void main(String[] args) {

//        testCreateObj();

//        testGetValues();

//        testWithSetter();

//        testWithAdjuster();

//        testTruncatedTo();

//        testZone();

//        testOffsetTime();

//        testPeriod();

//        testDuration();

        testTwelve();

    }

    /**
     * 示例-12 在Java 8中处理不同的时区
     * <p>
     * Java 8不仅将日期和时间进行了分离，同时还有时区
     * 现在已经有好几组与时区相关的类了，比如ZonId代表的是某个特定的时区，而ZonedDateTime代表的是带时区的时间
     * 它等同于Java 8以前的GregorianCalendar类。使用这个类，你可以将本地时间转换成另一个时区中的对应时间
     */
    private static void testTwelve() {
        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }


    /**
     * Duration类也是用来描述一段时间的, 他和Period类似,但是不同于Period的是，它表示的精度更细
     */
    private static void testDuration() {
        // A duration of 3 seconds and 5 nanoseconds
        Duration duration = Duration.ofSeconds(3, 5);
//        Duration oneDay = Duration.between(today, yesterday);
    }


    /**
     * Periods类用来表示例如“三个月零一天”这种描述一段时间的值
     * 这是目前看来与其他类不同的表示一段时间而不是时间点的类
     */
    private static void testPeriod() {
/*        // 3 years, 2 months, 1 day
        Period period = Period.of(3, 2, 1);

        // You can modify the values of dates using periods
        LocalDate newDate = oldDate.plus(period);
        ZonedDateTime newDateTime = oldDateTime.minus(period);

        // Components of a Period are represented by ChronoUnit values
        Assert.assertEquals(1, period.get(ChronoUnit.DAYS));*/
    }


    private static void testOffsetTime() {
/*        OffsetTime time = OffsetTime.now();
        // changes offset, while keeping the same point on the timeline
        OffsetTime sameTimeDifferentOffset = time.withOffsetSameInstant(offset);

        // changes the offset, and updates the point on the timeline
        OffsetTime changeTimeWithNewOffset = time.withOffsetSameLocal(offset);

        // Can also create new object with altered fields as before
        changeTimeWithNewOffset.withHour(3).plusSeconds(2);*/
    }


    /**
     * ZoneId是时区的标示符. 每一个ZoneId都表示这些时区遵循同样的规则
     * 当你编码时你可以考虑使用例如“PLT”,“Asia/Karachi,”这种字符串来创建ZoneId
     * <p>
     * ZoneOffset是一段时间内代表格林尼治时间/世界同一时间与时区之间的差异
     * 他能表示一个特殊的差异时区偏移量
     */
    private static void testZone() {
// You can specify the zone id when creating a zoned date time
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId id = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(dateTime, id);
        Assert.assertEquals(id, ZoneId.from(zoned));

        ZoneOffset zoneOffset = ZoneOffset.of("+2:00");
        System.out.println(zoneOffset.toString());
    }


    /**
     * 在Java SE 8中我们可以使用Java标准的getter方法来获取想要的值
     */
    private static void testTruncatedTo() {
        LocalTime timePoint = LocalTime.now();
        timePoint = timePoint.truncatedTo(ChronoUnit.SECONDS);
        System.out.println(timePoint.toString());

        timePoint = timePoint.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(timePoint.toString());

        timePoint = timePoint.truncatedTo(ChronoUnit.HOURS);
        System.out.println(timePoint.toString());

        timePoint = timePoint.truncatedTo(ChronoUnit.DAYS);
        System.out.println(timePoint.toString());
    }


    /**
     * 新的API提供的一个调节器的概念–用来封装通用的处理逻辑的一段代码
     * 你对任意时间使用WithAdjuster来设置一个或者多个字段
     * 或者可以使用PlusAdjuster来对字段进行增量或者减法操作. 值类型也可以被当做调节器使用,用来更新字段的值.
     * 新的API定义了一些内置的调节器, 但是如果你希望实现某些特定的业务逻辑，你也可以自己实现一个调节器
     */
    private static void testWithAdjuster() {

        LocalDateTime timePoint = LocalDateTime.now();
//        foo = timePoint.with(lastDayOfMonth());
//        bar = timePoint.with(previousOrSame(ChronoUnit.WEDNESDAY));

        // Using value classes as adjusters
        timePoint.with(LocalTime.now());

    }


    /**
     * 你也可以对对象的值进行运算操作
     * 因为新的API中所有的类型都是不可变的
     * 他们都是调用了with方法并返回一个新对象
     * 相当于使用了setter赋值
     * 对于每一个字段都有提供了基本的运算方法
     */
    private static void testWithSetter() {

        LocalDateTime timePoint = LocalDateTime.now();

        // Set the value, returning a new object
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);

        // You can use direct manipulation methods, or pass a value and field pair
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);

        System.out.println(yetAnother.toString());
        System.out.println(thePast.toString());
        System.out.println(timePoint.toString());
    }


    /**
     * 在Java SE 8中我们可以使用Java标准的getter方法来获取想要的值
     */
    private static void testGetValues() {
        LocalDateTime timePoint = LocalDateTime.now();
        int ldtYear = timePoint.getYear();
        Month ldtMonth = timePoint.getMonth();
        int ldtDay = timePoint.getDayOfMonth();
        int ldtHour = timePoint.getHour();
        int ldtMinute = timePoint.getMinute();
        int ldtSecond = timePoint.getSecond();
        int ldtNano = timePoint.getNano();
        System.out.println(ldtYear + "-" +
                ldtMonth.getValue() + "-" +
                ldtDay + " " +
                ldtHour + ":" +
                ldtMinute + ":" +
                ldtSecond + " " +
                ldtNano);


        LocalDate theDate = timePoint.toLocalDate();
        int year = theDate.getYear();
        Month month = theDate.getMonth();
        int day = theDate.getDayOfMonth();

        LocalTime theTime = timePoint.toLocalTime();
        int hour = theTime.getHour();
        int minute = theTime.getMinute();
        int second = theTime.getSecond();
        int nano = theTime.getNano();
    }


    /**
     * 在新的API中所有的核心类都可以由工厂方法很方便的构建
     * 当我通过某些类自身的字段来构建它时，可以使用of方法
     * 当我通过从另外一个类型的转换来构建它时，可以使用from方法
     * 同样也可以通过parse方法来由一个String参数构建它
     */
    private static void testCreateObj() {

        // The current date and time
        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println(timePoint.toString());

        // from values
        LocalDate date = LocalDate.of(2012, Month.DECEMBER, 12);
        System.out.println(date.toString());

        // middle of 1970
        LocalDate mid = LocalDate.ofEpochDay(150);
        System.out.println(mid.toString());

        // the train i took home today
        LocalTime home = LocalTime.of(17, 18);
        System.out.println(home.toString());

        // from a string
        LocalTime strTime = LocalTime.parse("17:18:30");
        System.out.println(strTime.toString());

    }



}
