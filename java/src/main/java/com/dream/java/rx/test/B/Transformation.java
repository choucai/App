package com.dream.java.rx.test.B;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * RxJava 教程第二部分：事件流基础之 转换数据流
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=964#ixzz4G2mG2dIA.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/1
 * @phone 152-5320-8570
 */
public class Transformation {

    public static void main(String[] args) {

//        testMap01();

//        testMap02();

//        testCastCompleted();
//        testCastError();

//        testOfType();

        //这两个函数中的时间对于记录日志和调试程序是非常有用的。这是用 Rx 的方式来获取异步调用的数据流信息
//        testTimestamp();
//        testInterval();

        // materialize 对于记录日志也是很有用的。materialize 把数据转换为元数据发射出去
//        testMaterialize();

//        testFlatMapOne();
//        testFlatMapMore();

//        testConcatMap();
//        testFlatMapIterable();
        testFlatMapIterableMore();


    }

    /**
     * 作为 Rx 开发者，我们需要知道在 Rx 中应该使用 Observable 数据流来发射数据而不要混合使用传统的 iterable
     * 但是如果你无法控制数据的来源，提供数据的一方只提供 iterable 数据，则依然可以直接使用这些数据
     * flatMapIterable 把多个 iterable 的数据按照顺序发射出来，不会交织发射。
     * flatMapIterable 还有另外一个重载函数可以用源 Observable 发射的数据来处理新的 iterable 中的每个数据
     * <p>
     * 注意，上面的 ori 参数取值为 源 Observable 发射出来的数据，也就是 1、 2、 3.
     * 而 rv 参数取值为 range(1, i) 参数生成的 iterable 中的每个数据，
     * 也就是分别为 [1]、[1,2]、[1,2,3]
     * 所以最终的结果就是：[11], [12, 22], [13, 23, 33].
     */
    private static void testFlatMapIterableMore() {
        Observable.range(1, 3).
                flatMapIterable(i -> range(1, i), (ori, rv) -> ori * rv).
                subscribe(System.out::println);
    }

    /**
     * flatMapIterable 和 flatMap 类似
     * 区别是 flatMap 参数把每个数据转换为 一个新的 Observable
     * 而 flatMapIterable 参数把一个数据转换为一个新的 iterable 对象
     * <p>
     * flatMapIterable 把生成的 3 个 iterable 合并为一个 Observable 发射
     */
    private static void testFlatMapIterable() {
        Observable.range(1, 3).flatMapIterable(i -> range(1, i)).subscribe(System.out::println);
    }

    public static Iterable<Integer> range(int start, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < start + count; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 如果你不想把新Observable中的数据交织在一起发射，则可以选择使用concatMap函数
     * 该函数会等第一个新的Observable完成后再发射下一个 新的 Observable 中的数据
     */
    private static void testConcatMap() {
        Observable.just(100, 150)
                .concatMap(i ->
                        Observable.interval(i, TimeUnit.MILLISECONDS)
                                .map(v -> i)
                                .take(3))
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.println("Completed"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * flatMap的参数会把源Observable中发射的每个数据转换为一个新的Observable， 然后 flatMap 再把这些新的Observable中发射的数据发射出来
     * 每个新的Observable数据都是按照他们产生的顺序发射出来，但是Observable之间数据的顺序可能会不一样。
     */
    private static void testFlatMapMore() {
        Observable<Integer> values = Observable.range(1, 3);
        values.flatMap(i -> Observable.range(0, i)).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("flatMap"));
    }


    /**
     * map 把一个数据转换为另外一个数据。而 flatMap 把源 Observable 中的一个数据替换为任意数量的数据，可以为 0 个，也可以为无限个
     * flatMap 把源 Observable 中的一个数据转换为一个新的 Observable 发射出去。
     */
    private static void testFlatMapOne() {
        Observable<Integer> values = Observable.just(2);
        values.flatMap(i -> Observable.range(0, i)).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("flatMap"));
    }


    /**
     * 元数据中包含了源 Observable 所发射的动作，是调用 onNext 还是 onComplete
     * 注意上图中，源 Observable 结束的时候， materialize 还会发射一个 onComplete 数据，然后才发射一个结束事件。
     * <p>
     * Notification 类包含了一些判断每个数据发射类型的方法，如果出错了还可以获取错误信息Throwable对象
     * dematerialize 函数会把 materialize 转换后的Observable再还原为 源 Observable
     */
    private static void testMaterialize() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.take(3).materialize().subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Materialize"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 如果你想知道前一个数据和当前数据发射直接的时间间隔，则可以使用timeInterval函数
     */
    private static void testInterval() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.take(3).timeInterval().subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("TimeInterval"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 这两个函数可以给数据流中的数据添加额外的时间相关的信息
     * timestamp 把数据转换为 Timestamped 类型，里面包含了原始的数据和一个原始数据是何时发射的时间戳
     */
    private static void testTimestamp() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.take(3).timestamp().subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Timestamp"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 如果你不想处理类型不一样的对象，则可以用 ofType
     * 该函数用来判断数据是否为该类型，如果不是则跳过这个数据
     */
    private static void testOfType() {
        Observable<Object> values = Observable.just(0, 1, "2", 3);
        values.ofType(Integer.class).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Map"));
    }


    /**
     * 如果遇到类型不一样的对象的话，就会抛出一个 error
     */
    private static void testCastError() {
        Observable<Object> values = Observable.just(0, 1, 2, "3");
        values.cast(Integer.class).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Map"));
    }


    /**
     * cast 是把一个对象强制转换为子类型的缩写形式。 假设源 Observable为 Observable
     * 但是你知道里面的数据都是 Integer 类型，则你可以使用 cast 把里面的数据转换为 Integer
     */
    private static void testCastCompleted() {
        Observable<Object> values = Observable.just(0, 1, 2, 3);
        values.cast(Integer.class).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Map"));
    }


    /**
     * 源 Observable 发射的为 String 类型数据，而我们需要的是 int 类型，则可以通过 map 把 String 转换为 int
     */
    private static void testMap02() {
        Observable<Integer> values = Observable.just("0", "1", "2", "3").map(Integer::parseInt);
        values.subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Map"));
    }


    /**
     * 如果你认为这种转换太简单了， 完全可以在 Subscriber 中完成，这样在设计架构上并不合理，没有有效的区分职责
     * 代码设计每个部分都有各自的职责，使用 map 可以有效的确保职责清晰。方便后续修改
     */
    private static void testMap01() {
        Observable<Integer> values = Observable.range(0, 4);
        values.map(i -> i + 3).subscribe(new com.dream.java.rx.test.B.entity.PrintSubscriber("Map"));
    }

}
