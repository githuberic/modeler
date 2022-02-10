package com.lgq.jbasic.proxy.dynamicproxy.e2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lgq
 */
public class DynamicProxy {
    public static void main(String[] args) {
        //设置这个值，在程序运行完成后，可以生成代理类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxyTest().bind(new Hello());
        hello.sayHello();
    }
}

interface IHello {
    /**
     *
     */
    void sayHello();
}

class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}

class DynamicProxyTest implements InvocationHandler {
    Object originalObj;

    Object bind(Object originalObj) {
        this.originalObj = originalObj;
        return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                originalObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Welcome");
        return method.invoke(originalObj, args);
    }
}
