package com.lgq.runtimep.proxy.dynamicproxy.example.e1;

/**
 * @author lgq
 */
public class CPU implements Device {
    @Override
    public void run() {
        System.out.println("CPU");
    }
}
