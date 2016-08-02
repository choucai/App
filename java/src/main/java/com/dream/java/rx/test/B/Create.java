package com.dream.java.rx.test.B;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/7/31
 * @phone 152-5320-8570
 */
public class Create {

    public static void main(String[] args) {

        testJust();
        System.out.println("*************************************");

        testEmpty();
        System.out.println("*************************************");

        testNever();
        System.out.println("*************************************");

        testError();
        System.out.println("*************************************");

        testDefer();
        System.out.println("*************************************");

        testCreate();
        System.out.println("*************************************");

        testRange();
        System.out.println("*************************************");

        testInterval();
        System.out.println("*************************************");

        testTimer1();
        System.out.println("*************************************");

        testTimer2();
        System.out.println("*************************************");


    }

    /**
     * 另外一个示例是，先等待一段时间，然后开始按照间隔的时间一直发射数据
     */
    private static void testTimer2() {
        Observable<Long> values = Observable.timer(2, 1, TimeUnit.SECONDS);
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Observable.timer 有两个重载函数。第一个示例创建了一个 Observable， 该 Observable 等待一段时间，然后发射数据 0 ，然后就结束了
     */
    private static void testTimer1() {
        Observable<Long> values = Observable.timer(1, TimeUnit.SECONDS);
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testInterval() {
        Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 该函数发射一个整数序列
     * 将生成一个从 10 到 24 的数字序列（从 10 开始，发射 15个数字）
     */
    private static void testRange() {
        Observable<Integer> values = Observable.range(10, 15);
        values.subscribe(v -> System.out.println("Received: " + v));
    }

    private static void testCreate() {
        Observable<String> values = Observable.create(subscriber -> {
            subscriber.onNext("Hello");
            subscriber.onCompleted();
        });
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }

    /**
     * 注意上面两个 subscriber 相隔 1秒订阅这个 Observable
     * 但是他们收到的时间数据是一样的！这是因为当订阅的时候，时间数据只调用一次
     * 其实你希望的是，当 一个 subscriber 订阅的时候才去获取当前的时间
     * defer 的参数是一个返回一个 Observable 对象的函数
     * 该函数返回的 Observable 对象就是 defer 返回的 Observable 对象
     * 重点是，每当一个新的 Subscriber 订阅的时候，这个函数就重新执行一次
     */
    private static void testDefer() {
        Observable<Long> now = Observable.defer(() -> Observable.just(System.currentTimeMillis()));

        now.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        now.subscribe(System.out::println);
    }

    /**
     * 这个 Observable 将会发射一个 error 事件,然后结束
     */
    private static void testError() {
        Observable<String> values = Observable.error(new Exception("Oops"));
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }

    /**
     * 这个 Observable 将不会发射任何事件和数据
     * 下面的代码不会打印任何东西,但是这个代码并没有阻塞住,实际上上面的代码立刻就执行完了
     */
    private static void testNever() {
        Observable<String> values = Observable.never();
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }

    /**
     * 这个函数创建的 Observable 只发射一个 onCompleted 事件就结束了
     */
    private static void testEmpty() {
        Observable<String> values = Observable.empty();
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }

    /**
     * just 函数创建一个[发射预定义好的数据的 Observable] ，发射完这些数据后，事件流就结束了
     */
    private static void testJust() {
        Observable<String> values = Observable.just("one", "two", "three");
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
    }


}
