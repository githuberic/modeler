package com.lgq.jbasic.proxy.dynamicproxy.example.e1;

/**
 * @author lgq
 */
public class GPU implements Device{
    @Override
    public void run() {
        System.out.println("GPU");
    }
}
