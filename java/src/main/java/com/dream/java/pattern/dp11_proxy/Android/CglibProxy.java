package com.dream.java.pattern.dp11_proxy.Android;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName());

        if (false) {
            return methodProxy.invokeSuper(o, args);
        } else {
            System.out.println("-------startAction+++Toast--------");
        }
        return null;
    }

}
