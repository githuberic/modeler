package com.lgq.modeler.designpattern.singleton.v4;

/**
 * Created by eric on 2019/12/29.
 * 静态内部类，延迟加载
 *
 * @author lgq
 */
public class Singleton {
    private Singleton() {
    }

    /**
     * 静态内部类
     */
    private static class SingletonInstance {
        private static final Singleton singleton = new Singleton();
    }

    /**
     * 静态内部类方式在singleton类被加载时被不会立刻实例化，
     * 在需要实例化时(调用getInstance时)
     * @return
     */
    public static Singleton getInstance() {
        return SingletonInstance.singleton;
    }
}
