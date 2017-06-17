package com.dream.java.rx.test.C;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.subjects.ReplaySubject;

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

//        testSingleError();

//        testToIterable();

//        testNextIterable();

//        testLastIterable();

//        testMostRecent();

//        testFuture();

        testDeadLock();


    }

    private static void testDeadLock() {
        ReplaySubject<Integer> subject = ReplaySubject.create();

        subject.toBlocking().forEach(v -> System.out.println(v));
        subject.onNext(1);
        subject.onNext(2);
        subject.onCompleted();
    }

    /**
     * 使用 toFuture 函数也可以把 BlockingObservable 转换为一个 Future，该方法只是创建一个 Future 并返回，不会阻塞
     * Future 可以让消费者决定如何处理异步操作。Future 也可以处理异常情况
     * 通过这种方式创建的 Future，要求 Observable 只发射一个数据，和 single 函数要求的一样
     * 如果发射了多个数据，则 Future 会抛出 java.lang.IllegalArgumentException.
     */
    private static void testFuture(){
        Observable<Long> values = Observable.timer(500, TimeUnit.MILLISECONDS);

        values.subscribe(v -> System.out.println("Emitted: " + v));

        Future<Long> future = values.toBlocking().toFuture();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * mostRecent 返回的 iterator 从来不会阻塞。他会缓存最近一个值，如果消费者比 生产者处理的速度慢，则有数据会丢失
     * 和 latest 不一样的是， 只要消费者需要数据，则缓存的数据就会直接返回
     * 这样，如果消费者处理数据的速度快，则消费者就会看到重复的数据。所以为了实现不阻塞的操作，该函数需要一个初始化的值
     * 如果 Observable 还没有发射数据，消费者这个时候看到的就是这个初始化的值
     */
    private static void testMostRecent() {
        Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);

        values.take(5).subscribe(v -> System.out.println("Emitted: " + v));

        Iterable<Long> iterable = values.take(5).toBlocking().mostRecent(-1L);
        for (long l : iterable) {
            System.out.println(l);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * latest 和 next 类似,区别就是 latest 会缓存一个数据
     * 使用 latest 的时候，如果在下一个数据发射之前，当前的数据还没有被消费者消费，则当前的值就会丢失
     * 如果 消费者比 生产者（Observable）发射的数据快，则 iterator 会阻塞并且等待下一个数据
     */
    private static void testLastIterable() {
        Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);

        values.take(5).subscribe(v -> System.out.println("Emitted: " + v));

        Iterable<Long> iterable = values.take(5).toBlocking().latest();
        for (long l : iterable) {
            System.out.println(l);
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 这种实现数据没有缓存,iterator总是等待下一个数据并立刻返回
     */
    private static void testNextIterable() {
        Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);

        values.take(5).subscribe(v -> System.out.println("Emitted: " + v));

        Iterable<Long> iterable = values.take(5).toBlocking().next();
        for (long l : iterable) {
            System.out.println(l);
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 把 Observable 所发射的所有数据给收集起来并缓存到一个集合中
     * 由于缓存的存在，所以不会丢失数据
     * 一单有下一个数据 next() 函数就返回,否则的话就阻塞到数据可用
     * 注意： iterable 的 hasNext() 或者 next() 函数都会阻塞直到有数据可用
     */
    private static void testToIterable() {
        Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);

        Iterable<Long> iterable = values.take(5).toBlocking().toIterable();
        for (long l : iterable) {
            System.out.println(l);
        }
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
