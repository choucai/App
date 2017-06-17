package com.dream.java.pattern.dp11_proxy.Android;

import net.sf.cglib.proxy.Enhancer;

/**
 * TODO.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class TestNetToast {


    public static void main(String[] args) {
        Presenter presenter = createPresenter(PresenterImpl.class);
        presenter.startActionLogin();
    }

    public static <T> T createPresenter(Class<T> clazz) {
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(cglibProxy);
        return (T) enhancer.create();
    }

}
