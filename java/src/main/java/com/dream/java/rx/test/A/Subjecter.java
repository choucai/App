package com.dream.java.rx.test.A;

import java.util.concurrent.TimeUnit;

import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

/**
 * RxJava 教程第一部分：入门之 关键的类
 * Read more: http://blog.chengyunfeng.com/?p=954#ixzz4FzwGww1v.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/7/31
 * @phone 152-5320-8570
 */
public class Subjecter {

    public static void main(String[] args) {

        testPublishSubject();
        System.out.println("*************************************");

        testReplaySubject();
        System.out.println("*************************************");
        testReplaySubjectWithSize();
        System.out.println("*************************************");
        testReplaySubjectWithTime();
        System.out.println("*************************************");

        testBehaviorSubject();
        System.out.println("*************************************");
        testBehaviorSubjectCompleted();
        System.out.println("*************************************");
        testBehaviorSubjectDefault();
        System.out.println("*************************************");

        testAsyncSubject();
        System.out.println("*************************************");

        testDefaultRule();
        System.out.println("*************************************");


    }

    /**
     * Rx 中有一些隐含的规则在代码中并不太容易看到
     * 一个重要的规则就是当一个事件流结束（onError 或者 onCompleted 都会导致事件流结束）后就不会发射任何数据了
     * 这些 Subject 的实现都遵守这个规则，subscribe 函数也拒绝违反该规则的情况
     */
    private static void testDefaultRule() {
        rx.subjects.Subject<Integer, Integer> s = ReplaySubject.create();
        s.subscribe(v -> System.out.println(v));
        s.onNext(0);
        s.onCompleted();
        s.onNext(1);
        s.onNext(2);
    }

    /**
     * AsyncSubject 也缓存最后一个数据
     * 区别是 AsyncSubject 只有当数据发送完成时（onCompleted 调用的时候）才发射这个缓存的最后一个数据
     * 可以使用 AsyncSubject 发射一个数据并立刻结束
     * 如果下面的示例不调用 s.onCompleted(); 则什么结果都不会打印出来
     */
    private static void testAsyncSubject() {
        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(v -> System.out.println(v));
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
    }

    /**
     * 由于 BehaviorSubject 的定义就是总是有可用的数据
     * 所以一般都会使用初始化值来创建 BehaviorSubject
     */
    private static void testBehaviorSubjectDefault() {
        BehaviorSubject<Integer> s = BehaviorSubject.create(0);
        s.subscribe(v -> System.out.println(v));
        s.onNext(1);
    }

    private static void testBehaviorSubjectCompleted() {
        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
        s.subscribe(
                v -> System.out.println("Late: " + v),
                e -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }

    /**
     * BehaviorSubject 只保留最后一个值
     * 等同于限制 ReplaySubject 的个数为 1 的情况
     * 在创建的时候可以指定一个初始值
     * 这样可以确保党订阅者订阅的时候可以立刻收到一个值
     */
    private static void testBehaviorSubject() {
        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
    }


    private static void testReplaySubjectWithTime() {
        ReplaySubject<Integer> s = ReplaySubject.createWithTime(150, TimeUnit.MILLISECONDS, Schedulers.immediate());
        s.onNext(0);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.onNext(1);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
    }

    /**
     * 缓存所有的数据并不是一个十分理想的情况
     * 如果 Observable 事件流运行很长时间
     * 则缓存所有的数据会消耗很多内存
     * 可以限制缓存数据的数量和时间
     * ReplaySubject.createWithSize 限制缓存多少个数据
     * 而 ReplaySubject.createWithTime 限制一个数据可以在缓存中保留多长时间
     */
    private static void testReplaySubjectWithSize() {
        ReplaySubject<Integer> s = ReplaySubject.createWithSize(2);
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
    }

    /**
     * ReplaySubject 可以缓存所有发射给他的数据
     * 当一个新的订阅者订阅的时候
     * 缓存的所有数据都会发射给这个订阅者
     * 由于使用了缓存
     * 所以每个订阅者都会收到所以的数据
     */
    private static void testReplaySubject() {
        ReplaySubject<Integer> s = ReplaySubject.create();
        s.subscribe(v -> System.out.println("Early:" + v));
        s.onNext(0);
        s.onNext(1);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(2);
    }

    /**
     * PublishSubject 是最直接的一个 Subject
     * 当一个数据发射到 PublishSubject 中时
     * PublishSubject 将立刻把这个数据发射到订阅到该 subject 上的所有 subscriber 中
     */
    private static void testPublishSubject() {
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        publishSubject.onNext(1);
        publishSubject.subscribe(System.out::println);
        publishSubject.onNext(2);
        publishSubject.onNext(3);
        publishSubject.onNext(4);
    }

}
