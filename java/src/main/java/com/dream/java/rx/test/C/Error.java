package com.dream.java.rx.test.C;

import com.dream.java.rx.test.B.entity.PrintSubscriber;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * RxJava 教程第三部分：驯服数据流之 高级错误处理.
 * <p>
 * http://blog.chengyunfeng.com/?p=970
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/29
 * @phone 152-5320-8570
 */
public class Error {


    public static void main(String[] args) {

//        testOnErrorReturn();

//        testOnErrorResumeNext();

//        testExceptionResumeNext();

//        testRetry();

//        testRetryWhen();

        testUsing();

    }

    /**
     * using 操作函数是用来管理资源的
     * 如果一个 Observable 需要使用一个资源来发射数据（比如 需要使用一个文件资源，从文件中读取内容）
     * 当该 Observable 结束的时候（不管是正常结束还是异常结束）就释放该资源
     * 这样你就不用自己管理资源了, 用 Rx 的方式来管理资源
     *
     * 有一点需要注意： 和使用 create 创建 Observable 一样
     * 我们需要自己来结束 Observable 的发射（onCompleted 的调用）
     * 如果你没有结束 Observable，则资源是永远不会释放的。
     */
    private static void testUsing() {
        Observable<Character> values = Observable.using(
                () -> {
                    String resource = "MyResource";
                    System.out.println("Leased: " + resource);
                    return resource;
                },
                (resource) -> {
                    return Observable.create(o -> {
                        for (Character c : resource.toCharArray())
                            o.onNext(c);
                        o.onCompleted();
                    });
                },
                (resource) -> System.out.println("Disposed: " + resource));

        values
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println(e));
    }

    /**
     * retryWhen 的参数是一个函数， 该函数的输入参数为一个异常 Observable，返回值为另外一个 Observable
     * 输入参数中包含了 retryWhen 发生时候遇到的异常信息；返回的 Observable 为一个信号，用来判别何时需要重试的：
     * <p>
     * – 如果返回的 Observable 发射了一个数据，retryWhen 将会执行重试操作
     * – 如果返回的 Observable 发射了一个错误信息，retryWhen 将会发射一个错误并不会重试
     * – 如果返回的 Observable 正常结束了，retryWhen 也正常结束
     */
    private static void testRetryWhen() {
        Observable<Integer> source = Observable.create(o -> {
            o.onNext(1);
            o.onNext(2);
            o.onError(new Exception("Failed"));
        });

        source.retryWhen((o) -> o
                .take(2)
                .delay(100, TimeUnit.MILLISECONDS))
                .timeInterval()
                .subscribe(
                        System.out::println,
                        System.out::println);
    }

    /**
     * 如果发生了不定性的异常，则通常会重试一下看看是否正常了
     * retry 的功能就算重新订阅到事件流，并重头重新开始发射数据
     * <p>
     * 没有参数的 retry() 函数会一直重试，直到没有异常发生为止
     * 而带有参数的 retry(n) 函数会重试 N 次， 如果 N 次后还是失败，则不再重试了，数据流发射一个异常信息并结束
     * <p>
     * 注意：示例中两次发射的数字不一样。说明 retry 并不像 replay 一样会缓存之前的数据
     * 一般情况下，这样的情况都是不合理的
     * 所以一般情况下，只有具有副作用的时候或者 Observable 是 hot 的时候 才应该使用 retry
     */
    private static void testRetry() {
        Random random = new Random();
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(random.nextInt() % 20);
            o.onNext(random.nextInt() % 20);
            o.onError(new Exception());
        });

        values
                .retry(1)
                .subscribe(v -> System.out.println(v));
    }

    /**
     * onExceptionResumeNext 和 onErrorResumeNext 的区别是只捕获 Exception
     */
    private static void testExceptionResumeNext() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("Rx");
            o.onNext("is");
            //o.onError(new Throwable() {}); // 这个为 error 不会捕获
            o.onError(new Exception()); // 这个为 Exception 会被捕获
        });

        values
                .onExceptionResumeNext(Observable.just("hard"))
                .subscribe(v -> System.out.println(v));
    }

    /**
     * onErrorResumeNext 的功能是:当错误发生的时候,.使用另外一个数据流继续发射数据
     * 在返回的 Observable 中是看不到错误信息的
     */
    private static void testOnErrorResumeNext() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(2);
            o.onError(new Exception("Oops"));
        });

        values
                .onErrorResumeNext(Observable.just(Integer.MAX_VALUE))
                .subscribe(new PrintSubscriber("with onError: "));
    }


    /**
     * onErrorReturn 操作函数的功能是:当发生错误的时候，发射一个默认值然后结束数据流
     * 所以 Subscriber 看不到异常信息,看到的是正常的数据流结束状态
     */
    private static void testOnErrorReturn() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("Rx");
            o.onNext("is");
            o.onError(new Exception("adjective unknown"));
        });

        values
                .onErrorReturn(e -> "Error: " + e.getMessage())
                .subscribe(v -> System.out.println(v));
    }

}
