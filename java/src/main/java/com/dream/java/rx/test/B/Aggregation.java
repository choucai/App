package com.dream.java.rx.test.B;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

/**
 * RxJava 教程第二部分：事件流基础之 聚合
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=962#ixzz4G2m2kj00.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/1
 * @phone 152-5320-8570
 */
public class Aggregation {

    /**
     * 本节的操作函数会使用源 Observable 中的事件流中的数据，然后把这些数据转换为其他类型的数据。返回结果是包含一个数据的 Observable
     *
     * @param args
     */
    public static void main(String[] args) {

//        testCount();

//        testFirst();

//        testLast();

//        testSingle();

//        testReduce();

//        testReduceCount();

//        testScan();

//        testScanReduce();

//        testReduceCollections();

//        testCollect();

//        testToList();

//        testToSortedList();

//        testToMapKey();
//        testToMapValue();
//        testToMapFactory();

//        testMultMap();
//        testMulMapFactory();

//        testGroupByWithNest();
//        testGroupByNoNest();

        testNest();


    }

    private static void testNest() {
        Observable.range(0, 3)
                .nest()
                .subscribe(ob -> ob.subscribe(System.out::println));
    }

    private static void testGroupByNoNest() {
        Observable<String> values = Observable.just(
                "first",
                "second",
                "third",
                "forth",
                "fifth",
                "sixth"
        );

        values.groupBy(word -> word.charAt(0))
                .flatMap(group ->
                        group.last().map(v -> group.getKey() + ": " + v)
                )
                .subscribe(v -> System.out.println(v));
    }

    private static void testGroupByWithNest() {
        Observable<String> values = Observable.just(
                "first",
                "second",
                "third",
                "forth",
                "fifth",
                "sixth"
        );

        values.groupBy(word -> word.charAt(0))
                .subscribe(
                        group -> group.last()
                                .subscribe(v -> System.out.println(group.getKey() + ": " + v))
                );
    }

    private static void testMulMapFactory() {
        Observable<Person> values = Observable.just(
                new Person("Will", 35),
                new Person("Nick", 40),
                new Person("Saul", 35)
        );

        values
                .toMultimap(
                        person -> person.age,
                        person -> person.name,
                        () -> new HashMap(),
                        (key) -> new ArrayList()) // 没有使用这个 key 参数
                .subscribe(new PrintSubscriber("toMap"));
    }

    private static void testMultMap() {
        Observable<Person> values = Observable.just(
                new Person("Will", 35),
                new Person("Nick", 40),
                new Person("Saul", 35)
        );

        values
                .toMultimap(
                        person -> person.age,
                        person -> person.name)
                .subscribe(new PrintSubscriber("toMap"));
    }

    private static void testToMapFactory() {
        Observable<Person> values = Observable.just(
                new Person("Will", 25),
                new Person("Nick", 40),
                new Person("Saul", 35)
        );

        values
                .toMap(
                        person -> person.name,
                        person -> person.age,
                        () -> new HashMap())
                .subscribe(new PrintSubscriber("toMap"));
    }

    private static void testToMapValue() {
        Observable<Person> values = Observable.just(
                new Person("Will", 25),
                new Person("Nick", 40),
                new Person("Saul", 35)
        );

        values
                .toMap(
                        person -> person.name,
                        person -> person.age)
                .subscribe(new PrintSubscriber("toMap"));
    }

    /**
     * toMap 把数据流 T 变为一个 Map<TKey,T>
     */
    private static void testToMapKey() {
        Observable<Person> values = Observable.just(
                new Person("Will", 25),
                new Person("Nick", 40),
                new Person("Saul", 35)
        );

        values
                .toMap(person -> person.name)
                .subscribe(new PrintSubscriber("toMap"));
    }

    /**
     * toSortedList 和前面类似，返回一个排序后的 list
     */
    private static void testToSortedList() {
        Observable<Integer> values = Observable.range(10, 5);

        values
                .toSortedList((i1, i2) -> i2 - i1)
                .subscribe(v -> System.out.println(v));
    }

    /**
     * 通常你不需要像这样手工的来收集数据， RxJava 提供了很多操作函数来实现这个功能
     */
    private static void testToList() {
        Observable<Integer> values = Observable.range(10, 5);

        values
                .toList()
                .subscribe(v -> System.out.println(v));
    }

    /**
     * 上面每一个值都创建一个新对象的性能是无法接受的
     * 为此， Rx 提供了一个 collect 函数来实现该功能，该函数使用了一个可变的 accumulator
     * 需要通过文档说明你没有遵守 Rx 的原则使用不可变对象，避免其他人误解：
     */
    private static void testCollect() {
        Observable<Integer> values = Observable.range(10, 5);

        values
                .collect(
                        () -> new ArrayList<>(),
                        (acc, value) -> acc.add(value))
                .subscribe(v -> System.out.println(v));
    }

    /**
     * 使用 reduce 可以把源Observable 发射的数据放到一个集合中
     */
    private static void testReduceCollections() {
        Observable<Integer> values = Observable.range(10, 5);

        values
                .reduce(
                        new ArrayList<>(),
                        (acc, value) -> {
                            acc.add(value);
                            return acc;
                        })
                .subscribe(v -> System.out.println(v));
    }

    /**
     * reduce 可以通过 scan 来实现： reduce(acc) = scan(acc).takeLast() 。所以 scan 比 reduce 更加通用。
     */
    private static void testScanReduce() {
        Subject<Integer, Integer> values = ReplaySubject.create();

        values
                .subscribe(new PrintSubscriber("Values"));

        values
                .scan((i1, i2) -> (i1 < i2) ? i1 : i2)
                .distinctUntilChanged()
                .subscribe(new PrintSubscriber("Min"));

        values.onNext(2);
        values.onNext(3);
        values.onNext(1);
        values.onNext(4);
        values.onCompleted();
    }

    /**
     * scan 和 reduce 很像,不一样的地方在于 scan会发射所有中间的结算结果
     */
    private static void testScan() {
        Observable<Integer> values = Observable.range(0, 5);

        values
                .scan((i1, i2) -> i1 + i2)
                .subscribe(new PrintSubscriber("Sum"));
    }

    /**
     * accumulator 参数返回的数据类型和 源 Observable 的数据类型可能是不一样的
     * accumulator 的第一个参数为前一步 accumulator 执行的结果,而第二个参数为 下一个数据
     * 使用一个初始化的值作为整个处理流程的开始
     * 下面的示例通过重新实现 count 函数来演示 reduce 的使用
     */
    private static void testReduceCount() {
        Observable<String> values = Observable.just("Rx", "is", "easy");

        values
                .reduce(0, (acc, next) -> acc + 1)
                .subscribe(new PrintSubscriber("Count"));
    }

    /**
     * 使用源Observable中的所有数据两两组合来生成一个单一的 数据
     * 在大部分重载函数中都需要一个函数用来定义如何组合两个数据变成一个
     */
    private static void testReduce() {
        Observable<Integer> values = Observable.range(0, 5);

        values
                .reduce((i1, i2) -> i1 + i2)
                .subscribe(new PrintSubscriber("Sum"));

        values
                .reduce((i1, i2) -> (i1 > i2) ? i2 : i1)
                .subscribe(new PrintSubscriber("Min"));
    }

    /**
     * single 只会发射源 Observable 中的一个数据，如果使用重载的带过滤条件的函数，则发射符合该过滤条件的那个数据
     * 和 first 、last 不一样的地方是，single 会检查数据流中是否只包含一个所需要的的数据，如果有多个则会抛出一个错误信息
     * 所以 single 用来检查数据流中是否有且仅有一个符合条件的数据。所以 single 只有在源 Observable 完成后才能返回
     * 使用 singleOrDefault 可以返回一个默认值
     */
    private static void testSingle() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values.take(10) // 获取前 10 个数据 的 Observable
                .single(v -> v == 5L) // 有且仅有一个 数据为 5L
                .subscribe(new PrintSubscriber("Single1"));

        values// 由于源 Observable 为无限的，所以这个不会打印任何东西
                .single(v -> v == 5L)
                .subscribe(new PrintSubscriber("Single2"));

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * last和lastOrDefault是和first一样的,区别就是当源Observable完成的时候,发射最后的数据
     * 如果使用重载的带 过滤参数的函数，则返回最后一个满足该条件的数据
     */
    private static void testLast() {
        Observable<Integer> values = Observable.range(3, 6);
        values.last(v -> v > 5).subscribe(new PrintSubscriber("Last"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * first 类似于 take(1) ,发射 源 Observable 中的第一个数据
     * 如果没有数据,则返回 ava.util.NoSuchElementException
     * 还有一个重载的带有 过滤 参数,则返回第一个满足该条件的数据
     * <p>
     * 可以使用firstOrDefault来避免java.util.NoSuchElementException错误信息
     * 这样如果没有发现数据，则发射一个默认的数据
     */
    private static void testFirst() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
        values.first(v -> v > 5).subscribe(new PrintSubscriber("First"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * count函数和Java集合中的size或者length一样,用来统计源Observable完成的时候一共发射了多少个数据
     * 如果发射数据的个数超过了 int 最大值，则可以使用 countLong 函数
     */
    private static void testCount() {
        Observable<Integer> values = Observable.range(0, 3);
        values.subscribe(new PrintSubscriber("Values"));
        values.count().subscribe(new PrintSubscriber("Count"));
    }

}
