package com.dream.java.rx.test.C;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * RxJava 教程第三部分：驯服数据流之 避免 monad.
 * <p>
 * Monad 是一种在模型域对象中封装了计算逻辑而不是数据的一种抽象数据构造类型
 * Read more: http://blog.chengyunfeng.com/?p=969#ixzz4ID3R5T23
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/24
 * @phone 152-5320-8570
 */
public class Monad {

    private static void inRead() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

//        testForEach();

//        testForEachBlock();

//        testForEachError();

//        testFirstBlock();
        testSingleError();

    }

    private static void testSingleError() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        try {
            long value = values.take(5).toBlocking().single(i -> i > 2);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
    }

    /**
     * BlockingObservable 还有这3个函数
     * 以及带有默认值的另外三个函数：firstOrDefault, lastOrDefault 和 singleOrDefault
     * 这些函数会阻塞当前的线程直到有数据发射出来并返回符合结果的数据
     */
    private static void testFirstBlock() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        long value = values.take(5).toBlocking().first(i -> i > 2);
        System.out.println(value);
    }

    /**
     * 通过 forEach 可以处理 Observable 每个发射出来的数据
     */
    private static void testForEach() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.take(5).forEach(v -> System.out.println(v));
        System.out.println("Subscribed");

        inRead();
    }

    /**
     * 使用的是阻塞的 Observable，所以当 forEach 执行完后，才会执行后面的打印 Subscribed 的代码
     */
    private static void testForEachBlock() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.take(5).toBlocking().forEach(v -> System.out.println(v));
        System.out.println("Subscribed");
    }

    /**
     * 阻塞的 Observable 也没有 onError 和 onCompleted 函数
     * 当执行完成的时候，就执行完了；当错误发生的时候，异常就直接就地抛出了
     */
    private static void testForEachError() {
        Observable<Long> values = Observable.error(new Exception("Oops"));

        try {
            values.take(5).toBlocking().forEach(v -> System.out.println(v));
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("Subscribed");
    }

}
