package com.dream.java.rx.test.A;

import rx.Subscription;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

/**
 * RxJava 教程第一部分：入门之 生命周期管理
 * Read more: http://blog.chengyunfeng.com/?p=954#ixzz4FzwWgvOF.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/7/31
 * @phone 152-5320-8570
 */
public class Lifecycle {

    public static void main(String[] args) {

        onLifecycleError();
        System.out.println("*************************************");

        onLifecycleUnsubscribe();
        System.out.println("*************************************");

        onLifecycleOther();
        System.out.println("*************************************");

        onLifecycleCompleted();
        System.out.println("*************************************");

        onLifecycleResource();
        System.out.println("*************************************");

    }

    private static void onLifecycleResource() {
        Subscription s = Subscriptions.create(() -> System.out.println("Clean"));
        s.unsubscribe();
    }

    /**
     * onError 和 onCompleted 意味着结束事件流
     * observable 需要遵守该规范
     * 在 onError 或者 onCompleted 发生后就不应该再发射事件了
     */
    private static void onLifecycleCompleted() {
        Subject<Integer, Integer> values = ReplaySubject.create();
        Subscription subscription1 = values.subscribe(
                v -> System.out.println("First: " + v),
                e -> System.out.println("First: " + e),
                () -> System.out.println("Completed")
        );
        values.onNext(0);
        values.onNext(1);
        values.onCompleted();
        values.onNext(2);
    }

    /**
     * 一个 observer 调用 unsubscribe 取消监听并不妨碍同一个 observable 上的其他 Observer 对象
     */
    private static void onLifecycleOther() {
        Subject<Integer, Integer> values = ReplaySubject.create();
        Subscription subscription1 = values.subscribe(
                v -> System.out.println("First: " + v)
        );
        Subscription subscription2 = values.subscribe(
                v -> System.out.println("Second: " + v)
        );
        values.onNext(0);
        values.onNext(1);
        subscription1.unsubscribe();
        System.out.println("Unsubscribed first");
        values.onNext(2);
    }

    private static void onLifecycleUnsubscribe() {
        Subject<Integer, Integer> values = ReplaySubject.create();
        Subscription subscription = values.subscribe(
                v -> System.out.println(v),
                e -> System.err.println(e),
                () -> System.out.println("Done")
        );
        values.onNext(0);
        values.onNext(1);
        subscription.unsubscribe();
        values.onNext(2);
    }

    private static void onLifecycleError() {
        Subject<Integer, Integer> s = ReplaySubject.create();
        s.subscribe(
                v -> System.out.println(v),
                e -> System.err.println(e));
        s.onNext(0);
        s.onError(new Exception("Oops"));
    }


}
