package com.lgq.modeler.designpattern.singleton.v2;

/**
 * Created by eric on 2019/12/29.
 * 备注：只能在单线程下使用
 *
 * @author lgq
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
