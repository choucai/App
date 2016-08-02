package com.dream.java.rx.test.B;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

/**
 * RxJava 教程第二部分：事件流基础之 检查数据
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=961#ixzz4G2Wv4PLd.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/1
 * @phone 152-5320-8570
 */
public class Inspection {

    public static void main(String[] args) {

//        testAll();
        testAllCompleted();
//        testAllError();
//        testAllIfError();

//        testExists();

//        testIsEmpty();

//        testContains();

//        testDefaultIfEmpty();
//        testDefaultIfEmptyError();

//        testElementAt();
//        testElementAtOrDefault();

//        testSequenceEqual();
//        testSequenceEqualError();


    }

    private static void testSequenceEqualError() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(2);
            o.onError(new Exception());
        });

        Observable.sequenceEqual(values, values)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 个操作函数是用来比较两个 Observable 发射的数据是否是一样的，同样位置的数据是一样的
     * 要求两个 Observable 发射的数据个数是一样的并且每个位置上的数据也是一样的
     * 该函数内部用 Object.equals 来比较数据，当然你也可以自己指定一个比较函数
     */
    private static void testSequenceEqual() {
        Observable<String> strings = Observable.just("1", "2", "3");
        Observable<Integer> ints = Observable.just(1, 2, 3);

        Observable.sequenceEqual(strings, ints, (s, i) -> s.equals(i.toString()))
//Observable.sequenceEqual(strings, ints)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 该函数和访问数组或者集合类似，如果 Observable 发射的数据个数没有这么多，则会抛出 java.lang.IndexOutOfBoundsException
     * 可以使用一个默认值（elementAtOrDefault）来避免抛出 java.lang.IndexOutOfBoundsException
     */
    private static void testElementAtOrDefault() {
        Observable<Integer> values = Observable.range(100, 10);

        Subscription subscription = values
                .elementAtOrDefault(22, 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 从特定的位置选择一个数据发射
     */
    private static void testElementAt() {
        Observable<Integer> values = Observable.range(100, 10);

        Subscription subscription = values
                .elementAt(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 只有当 onCompleted 事件发生了，并且 Observable 没有发射任何数据的时候
     * 才会使用默认值；否则不会使用默认值
     * 如果发生了错误，则还会有错误的结果
     */
    private static void testDefaultIfEmptyError() {
        Observable<Integer> values = Observable.error(new Exception());

        Subscription subscription = values
                .defaultIfEmpty(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 如果你不想单独处理没有发射任何数据的情况（需要用 isEmpty 函数来检查是否为空）
     * 则可以使用 defaultIfEmpty 函数来强制一个空的 Observable 发射一个默认数据
     */
    private static void testDefaultIfEmpty() {
        Observable<Integer> values = Observable.empty();

        Subscription subscription = values
                .defaultIfEmpty(2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * contains 使用 Object.equals 函数来判断源 Observable 是否发射了相同的数据
     * 只要遇到相同的数据，则 contains 就立刻返回
     */
    private static void testContains() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .contains(4L)
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
     * 判断一个 Observable 是否是空的，也就是没有发射任何数据就结束了
     * 只要源 Observable 发射了一个数据，isEmpty 就立刻返回 false
     * 只有当源 Observable 完成了并且没有发射数据，isEmpty 才返回 true
     */
    private static void testIsEmpty() {
        Observable<Long> values = Observable.timer(1000, TimeUnit.MILLISECONDS);

        Subscription subscription = values
                .isEmpty()
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
     * 如果源 exists 发射的数据中有一个满足条件，则 exists 就返回 true
     * exists 和 all 一样也是返回一个 Observable 而不是直接返回 布尔值
     */
    private static void testExists() {
        Observable<Integer> values = Observable.range(0, 5);

        Subscription subscription = values
                .exists(i -> i > 2)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 如果源 Observable 在出错之前就发射了一个不满足条件的数据，
     * 则 源 Observable 的错误对 all 没有影响（ all 遇到不满足条件的数据就结束了，结束的Observable 无法再继续发射数据了）
     */
    private static void testAllIfError() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(2);
            o.onError(new Exception());
        });

        Subscription subscription = values
                .all(i -> i % 2 == 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * 如果源 Observable 出现了错误，则 all 操作就没有意义了，all 会直接发射一个 error 然后结束
     */
    private static void testAllError() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(0);
            o.onNext(2);
            o.onError(new Exception());
        });

        Subscription subscription = values
                .all(i -> i % 2 == 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }

    /**
     * all 函数返回的是一个【发射一个布尔值的 Observable】，而不是直接返回一个布尔值。
     * 原因在于我们并不知道源 Observable 何时才结束数据流的发射，只有当源 Observable 发射结束的时候， all 函数才知道结果是否都满足条件。
     * 只要遇到一个不满足条件的数据，all 函数就立刻返回 false。 只有当源 Observable 结束发射并且所发射的所有数据都满足条件的时候才会产生 true。
     * 在 observable 内返回结果可以方便的实现非阻塞操作。 在下面的示例中可以看到 all 在遇到不满足的数据的时候就立刻结束了。
     */
    private static void testAllCompleted() {
        Observable<Long> values = Observable.interval(150, TimeUnit.MILLISECONDS).take(5);

        Subscription subscription = values
                .all(i -> i < 3) // Will fail eventually
                .subscribe(
                        v -> System.out.println("All: " + v),
                        e -> System.out.println("All: Error: " + e),
                        () -> System.out.println("All: Completed")
                );

        Subscription subscription2 = values
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
     * all 函数用来判断 observable 中发射的所有数据是否都满足一个条件
     */
    private static void testAll() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(0);
            o.onNext(10);
            o.onNext(10);
            o.onNext(2);
            o.onCompleted();
        });

        Subscription evenNumbers = values
                .all(i -> i % 2 == 0)
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }


}
