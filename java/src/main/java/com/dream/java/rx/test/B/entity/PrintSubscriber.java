package com.dream.java.rx.test.B.entity;

import rx.Subscriber;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/8/2
 * @phone 152-5320-8570
 */
public class PrintSubscriber extends Subscriber{

    private final String name;
    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onCompleted() {
        System.out.println(name + ": Completed");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println(name + ": Error: " + e);
    }

    @Override
    public void onNext(Object v) {
        System.out.println(name + ": " + v);
    }

}
