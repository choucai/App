package com.dream.java.rx.test.C;

import com.dream.java.rx.test.B.entity.PrintSubscriber;
import com.dream.java.rx.test.C.entity.Data;
import com.dream.java.rx.test.C.entity.Indexed;

import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.subjects.ReplaySubject;

/**
 * RxJava 教程第三部分：驯服数据流之副作用
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=968#ixzz4GKE2eedj.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/4
 * @phone 152-5320-8570
 */
public class SideEffects {

    static Observable<String> service() {
        return  Observable.just("First", "Second", "Third")
                .doOnEach(new PrintSubscriber("Log"));
    }


    public static void main(String[] args) {

//        testSideEffectsOne();

//        testSideEffectsTwo();

//        testDoOnEach();

//        testService();

//        testDoOnSubscribeOrUnsubscribe();

        testObjectRefrence();
    }

    private static void testObjectRefrence() {
        Observable<Data> data = Observable.just(
                new Data(1, "Microsoft"),
                new Data(2, "Netflix")
        );
        data.subscribe(d -> d.name = "Garbage");
        data.subscribe(d -> System.out.println(d.id + ": " + d.name));
    }

    private static void testDoOnSubscribeOrUnsubscribe() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        Observable<Integer> values = subject
                .doOnSubscribe(() -> System.out.println("New subscription"))
                .doOnUnsubscribe(() -> System.out.println("Subscription over"));

        Subscription s1 = values.subscribe(new PrintSubscriber("1st"));
        subject.onNext(0);
        Subscription s2 = values.subscribe(new PrintSubscriber("2st"));
        subject.onNext(1);
        s1.unsubscribe();
        subject.onNext(2);
        subject.onNext(3);
        subject.onCompleted();
    }

    private static void testService() {
        service()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 5)
                .subscribe(new PrintSubscriber("Process"));
    }

    private static void testDoOnEach() {
        Observable<String> values = Observable.just("side", "effects");
        values
                .doOnEach(new PrintSubscriber("Log"))
                .map(new Func1<String, Object>() {
                    @Override
                    public Object call(String s) {
                        return s.toString();
                    }
                })
                .subscribe(new PrintSubscriber("Process"));
    }

    private static void testSideEffectsTwo() {
        Observable<String> values = Observable.just("No", "side", "effects", "please");

        Observable<com.dream.java.rx.test.C.entity.Indexed> indexed =
                values.scan(
                        new com.dream.java.rx.test.C.entity.Indexed(0, null),
                        (prev, v) -> new Indexed(prev.index + 1, v))
                        .skip(1);
        indexed.subscribe(w -> System.out.println("1st observer: " + w.index + ": " + w.item));
        indexed.subscribe(w -> System.out.println("2nd observer: " + w.index + ": " + w.item));
    }

    private static void testSideEffectsOne() {
        Observable<String> values = Observable.just("No", "side", "effects", "please");

        com.dream.java.rx.test.C.entity.Inc index = new com.dream.java.rx.test.C.entity.Inc();

        Observable<String> indexed =
                values.map(w -> {
                    index.inc();
                    return w;
                });
        indexed.subscribe(w -> System.out.println("1st observer: " + index.getCount() + ": " + w));
        indexed.subscribe(w -> System.out.println("2nd observer: " + index.getCount() + ": " + w));
    }


}
