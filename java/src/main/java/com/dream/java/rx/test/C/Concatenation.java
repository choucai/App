package com.dream.java.rx.test.C;

import com.dream.java.rx.test.B.entity.PrintSubscriber;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * RxJava 教程第三部分：驯服数据流之 组合数据流.
 * <p>
 * Read more: http://blog.chengyunfeng.com/?p=972#ixzz4Is4nCBX5
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/31
 * @phone 152-5320-8570
 */
public class Concatenation {


    public static void main(String[] args) {

//        testConcat();

//        textConcatDynimic();

//        testConcatWith();

//        testRepeat();

        testRepeatWhen();


    }

    private static void testRepeatWhen() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values
                .take(2)
                .repeatWhen(ob -> {
                    return ob.take(2);
                })
                .subscribe(new PrintSubscriber("repeatWhen"));
    }

    /**
     * repeat 顾名思义,可以重复的发射自己
     * repeat 不会缓存之前的数据,当再次发射数据的时候,会从新就算数据
     */
    private static void testRepeat() {
        Observable<Integer> words = Observable.range(0, 2);
        words.repeat(3).subscribe(System.out::println);
    }

    /**
     * concatWith函数是concat的另外一种使用方式
     * 可以通过串联的方法来一个一个的组合数据流
     */
    private static void testConcatWith() {
        Observable<Integer> seq1 = Observable.range(0, 3);
        Observable<Integer> seq2 = Observable.range(10, 3);
        Observable<Integer> seq3 = Observable.just(20);

        seq1.concatWith(seq2)
                .concatWith(seq3)
                .subscribe(System.out::println);
    }

    /**
     * 如果需要组合的数据流是动态的,则依然可以使用concat来组合返回多个Observable的情况
     */
    private static void textConcatDynimic() {
        Observable<String> words = Observable.just("First", "Second", "Third", "Fourth", "Fifth", "Sixth");
        Observable.concat(words.groupBy(v -> v.charAt(0))).subscribe(System.out::println);
    }

    /**
     * concat操作函数把多个数据流按照顺序一个一个的发射数据
     * 第一个数据流发射完后,继续发射下一个
     * <p>
     * concat的行为有点像concatMap操作函数的扁平处理[flattening phase]
     * 事实上,concatMap等价于先应用map操作函数然后再使用concat
     */
    private static void testConcat() {
        Observable<Integer> seq1 = Observable.range(0, 3);
        Observable<Integer> seq2 = Observable.range(10, 3);
        Observable.concat(seq1, seq2).subscribe(System.out::println);
    }

}
