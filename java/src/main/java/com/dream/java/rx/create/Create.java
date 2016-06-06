package com.dream.java.rx.create;

import rx.Observable;
import rx.Subscriber;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016/6/6
 * @phone 152-5320-8570
 */
public class Create {

    public static void main(String[] args) {

        //create 方法默认不在任何特定的调度器上执行
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        for (int i = 1; i < 5; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                System.out.println("Next: " + item);
            }

            @Override
            public void onError(Throwable error) {
                System.err.println("Error: " + error.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }
        });
    }

}
