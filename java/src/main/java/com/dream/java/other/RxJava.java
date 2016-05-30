package com.dream.java.other;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * RxJava.
 * Rxjava的看起来很想设计模式中的观察者模式
 * 但是有一点明显不同,那就是如果一个Observerble没有任何的的Subscriber
 * 那么这个Observable是不会发出任何事件的
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-30 上午9:39.
 * @phone 152-5320-8570
 */
public class RxJava {


    public static void main(String args[]) {
        // RxJava原理
//        howWork();
        // 简洁写法
//        cleanWriting();
        // 操作符
//        operatorMap1();
        operatorMap2();
    }

    /**
     * RxJava工作原理
     */
    private static void howWork() {
        // 事件源
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("William to dream !");
                        subscriber.onCompleted();
                    }
                });
        // 订阅者
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext === " + s);
            }
        };
        // 订阅事件
        myObservable.subscribe(mySubscriber);
    }


    /**
     * RxJava简洁写法
     */
    private static void cleanWriting() {
        // 简洁写法1
        Observable<String> myObservable = Observable.just("Dream to william !");
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("Action1 = onNext = " + s);
            }
        };
        myObservable.subscribe(onNextAction);

        // 简洁写法2
        Observable.
                just("In order to do somethings...").
                subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("Action1 = onNext = " + s);
                    }
                });

        // 简洁写法3
        Observable.just("Hello, world!").subscribe(s -> System.out.println(s));
    }


    /**
     * RxJava-操作符(Operators)
     * 操作符就是为了解决对Observable对象的变换的问题
     * 操作符用于在Observable和最终的Subscriber之间修改Observable发出的事件
     */
    private static void operatorMap1() {
        // map操作符-就是用来把把一个事件转换为另一个事件
        Observable.
                just("Hello William!").
                map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " Come on !";
                    }
                }).
                subscribe(s -> System.out.println(s));

        // 简洁写法
        Observable.
                just("Hi , I miss ").
                map(s -> s + "you").
                subscribe(s -> System.out.println(s));

    }


    /**
     * map操作符更有趣的一点是它不必返回Observable对象返回的类型
     * 你可以使用map操作符返回一个发出新的数据类型的observable对象
     */
    private static void operatorMap2() {

        Observable.just("Hello, world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(i -> System.out.println(Integer.toString(i)));

        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .subscribe(i -> System.out.println(Integer.toString(i)));

        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));

    }

}
