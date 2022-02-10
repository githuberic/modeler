package com.lgq.jbasic.proxy.dynamicproxy.practices.e4;

import com.lgq.jbasic.proxy.dynamicproxy.practices.Alipay;
import com.lgq.jbasic.proxy.dynamicproxy.practices.Payable;

/**
 * @author lgq
 */
public class App {
    public static void main(String[] args) {
        // 创建被代理对象
        Alipay target = new Alipay();

        // 实现自己的逻辑
        InvocationHandler logHandler = new LogInvocationHandler(target);

        // 得到代理对象
        Payable proxy = (Payable) Proxy.newProxyInstance(new MyClassLoader(), Payable.class, logHandler);

        // 调用代理对象目标方法
        proxy.pay();
    }
}
