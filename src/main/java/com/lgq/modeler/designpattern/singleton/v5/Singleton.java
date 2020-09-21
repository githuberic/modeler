package com.lgq.modeler.designpattern.singleton.v5;

/**
 * Created by eric on 2019/12/29.
 * 1:代码简洁，线程安全,支持多线程同步
 * 2:防止序列化、反射实例化多个实例;
 *
 * @author lgq
 */
public enum Singleton {
    INSTANCE;
    private SingletonObj singletonObj;

    Singleton() {
        singletonObj = new SingletonObj();
    }

    public SingletonObj getInstance() {
        return this.singletonObj;
    }
}
