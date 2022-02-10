package com.lgq.jbasic.proxy.dynamicproxy.example.e2;

import com.lgq.jbasic.proxy.dynamicproxy.example.Payable;

/**
 * @author lgq
 */
public class App {
    public static void main(String[] args) {
        // 类加载器的，可以灵活地选择不同的类加载器来完成这个操作
        Payable payable = (Payable) Proxy.newProxyInstance(new MyClassLoader());
        payable.pay();
    }
}
