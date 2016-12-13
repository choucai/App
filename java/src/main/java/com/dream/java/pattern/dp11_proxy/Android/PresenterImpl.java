package com.dream.java.pattern.dp11_proxy.Android;

/**
 * TODO.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class PresenterImpl implements Presenter{

    public PresenterImpl() {
        System.out.println("-------PresenterImpl--------");
    }

    @Override
    public void startActionLogin() {
        System.out.println("-------startAction+++Login--------");
    }

}
