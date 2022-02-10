package com.lgq.jbasic.proxy.dynamicproxy.example.e2;

import com.lgq.jbasic.proxy.dynamicproxy.example.Payable;

/**
 * @author lgq
 */
public class App {
    public static void main(String[] args) {
        Payable payable = (Payable) Proxy.newProxyInstance(new MyClassLoader());
        payable.pay();
    }
}
