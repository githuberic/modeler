package com.lgq.singleton.v1;

/**
 * Created by eric on 2019/12/29.
 *
 * @author lgq
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
