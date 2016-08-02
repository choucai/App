package com.dream.java.rx.test.B;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * RxJava 教程第二部分：事件流基础之 过滤数据
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=960#ixzz4G2LNbOyz.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/1
 * @phone 152-5320-8570
 */
public class Filter {

    public static void main(String[] args) {

//        testFilter();

//        testDistinct();

//        testDistinctKey();

//        testDistinctUntilChanged();

//        testDistinctUntilChangedKey();

//        testIgnorElements();

        testTake();

//        testTakeNum();

//        testSkip();

//        testTakeTime();

//        testSkipTime();

//        testTakeWhile();

//        testSkipWhile();

//        testSkipLast();

//        testTakeUtil();

//        testSkipUtil();
    }

    /**
     * skipUntil 也是一样，当收到另外一个 Observable 发射数据的时候，就开始接收 源 Observable 的数据
     */
    private static void testSkipUtil() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        Observable<Long> cutoff = Observable.timer(250, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .skipUntil(cutoff)
                .subscribe(
                        v -> System.out.println(v),
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
     * takeUntil 和 skipUntil 这两个函数和 takeWhile 、skipWhile 刚好相反
     * 当判断条件为 false 的时候， takeUntil 保留该数据
     * <p>
     * takeUntil 和 skipUntil 还有另外一种不一样的重载函数
     * 切断的条件为 另外一个 Observable 发射数据的时刻
     */
    private static void testTakeUtil() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        Observable<Long> cutoff = Observable.timer(250, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .takeUntil(cutoff)
                .subscribe(
                        v -> System.out.println(v),
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
     * skip 和 take 是从头开始索引数据，而 skipLast 和 takeLast 和他们相反，是从末尾开始索引数据
     */
    private static void testSkipLast() {
        Observable<Integer> values = Observable.range(0, 5);

        Subscription subscription = values
                .skipLast(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 不出意料， skipWhile 跳过过滤条件为 true 的数据
     */
    private static void testSkipWhile() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .skipWhile(v -> v < 2)
                .subscribe(
                        v -> System.out.println(v),
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
     * 这两个函数是使用一个 predicate 参数来当做判断条件
     * 如果判断条件返回为 ture， 则 takeWhile 保留该数据
     */
    private static void testTakeWhile() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .takeWhile(v -> v < 2)
                .subscribe(
                        v -> System.out.println(v),
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
     * 除了根据发射数据的索引来过滤数据以外，还可以使用数据流发射的时间来过滤。比如过滤掉前五秒发射的数据
     */
    private static void testSkipTime() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .skip(250, TimeUnit.MILLISECONDS)
                .subscribe(
                        v -> System.out.println(v),
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
     * 除了根据发射数据的索引来过滤数据以外，还可以使用数据流发射的时间来过滤。比如过滤掉前五秒发射的数据
     */
    private static void testTakeTime() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .take(250, TimeUnit.MILLISECONDS)
                .subscribe(
                        v -> System.out.println(v),
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
     * skip 返回 take 操作忽略的另外一部分数据。也就是跳过前面 N 个数据
     */
    private static void testSkip() {
        Observable<Integer> values = Observable.range(0, 5);

        Subscription subscription = values
                .skip(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }


    /**
     * 只要第 N 个数据可用， take 操作就结束了
     * 如果在 N 个数据发射之前发生了 error， error 信息会继续传递到下一个 Observable
     * 如果 第 N 个数据发射后， take 就不再关心源 Observable 的状态了
     */
    private static void testTakeNum() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onError(new Exception("Oops"));
        });

        Subscription subscription = values
                .take(1)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 下面两个操作函数依据发射数据的索引来在特定的位置切断数据流，可以从头开始切断也可以从末尾开始切断
     * take 从头开始获取前 N 个数据，而 skip 则是从头开始 跳过 N 个数据
     * 注意，如果发射的数据比 N 小，则这两个函数都会发射一个 error
     */
    private static void testTake() {
        Observable<Integer> values = Observable.range(0, 5);

        Subscription first2 = values
                .take(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );

    }

    /**
     * ignoreElements会忽略所有发射的数据，只让onCompleted和onError可以通过
     * ignoreElements()和使用filter(v -> false)是一样的效果
     */
    private static void testIgnorElements() {
        Observable<Integer> values = Observable.range(0, 10);

        Subscription subscription = values
                .ignoreElements()
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 同样 distinctUntilChanged 也可以使用一个生成 key 的参数
     */
    private static void testDistinctUntilChangedKey() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("First");
            o.onNext("Second");
            o.onNext("Third");
            o.onNext("Fourth");
            o.onNext("Fifth");
            o.onCompleted();
        });

        Subscription subscription = values
                .distinctUntilChanged(v -> v.charAt(0))
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * distinct还有个变体是distinctUntilChanged
     * 区别是distinctUntilChanged只过滤相邻的key一样的数据
     */
    private static void testDistinctUntilChanged() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(1);
            o.onNext(2);
            o.onNext(3);
            o.onNext(2);
            o.onCompleted();
        });

        Subscription subscription = values
                .distinctUntilChanged()
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * distinct 还有一个重载函数,该函数有个生成 key 的参数
     * 每个发射的数据都使用该参数生成一个 key,然后使用该key 来判断数据是否一样
     */
    private static void testDistinctKey() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("First");
            o.onNext("Second");
            o.onNext("Third");
            o.onNext("Fourth");
            o.onNext("Fifth");
            o.onCompleted();
        });

        Subscription subscription = values
                .distinct(v -> v.charAt(0))
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * distinct 函数用来过滤掉已经出现过的数据
     */
    private static void testDistinct() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(1);
            o.onNext(2);
            o.onNext(3);
            o.onNext(2);
            o.onCompleted();
        });

        Subscription subscription = values
                .distinct()
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * filter 函数使用一个 predicate 函数接口来判断每个发射的值是否能通过这个判断
     * 如果返回 true，则该数据继续往下一个（过滤后的） Observable 发射
     */
    private static void testFilter() {
        Observable<Integer> values = Observable.range(0, 10);
        Subscription oddNumbers = values
                .filter(v -> v % 2 == 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }


}
