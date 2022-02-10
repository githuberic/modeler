package com.lgq.jbasic.proxy.dynamicproxy.e1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lgq
 */
public class SecurityHandler implements InvocationHandler {

    private Object targetObject;

    public Object createProxyInstanceObject(Object targetobObject) {
        this.targetObject = targetobObject;

        return Proxy.newProxyInstance(targetobObject.getClass().getClassLoader(),
                targetobObject.getClass().getInterfaces(),
                this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        checkSecurity();

        //调用目标方法
        return method.invoke(targetObject, args);
    }

    private void checkSecurity() {
        System.out.println("-----------checkSecurity----------");
    }
}

