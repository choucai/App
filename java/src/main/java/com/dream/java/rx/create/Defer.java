package com.dream.java.rx.create;

import rx.Observable;
import rx.functions.Func0;

/**
 * Defer 操作符会一直等待直到有观察者订阅它，然后它使用Observable工厂方法生成一个
 * Observable。它对每个观察者都这样做，因此尽管每个订阅者都以为自己订阅的是同一个
 * Observable，事实上每个订阅者获取的是它们自己的单独的数据序列。
 * 在某些情况下，等待直到最后一分钟（ 就是知道订阅发生时） 才生成Observable可以确保
 * Observable包含最新的数据.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/6/6
 * @phone 152-5320-8570
 */
public class Defer {

    public static void main(String[] args) {
        // defer 方法默认不在任何特定的调度器上执行

    }

}
