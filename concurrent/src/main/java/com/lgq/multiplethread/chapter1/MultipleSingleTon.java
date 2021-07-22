package com.lgq.multiplethread.chapter1;


/**
 * Created by eric on 2019/12/14.
 * 该方法中Singleton有一个静态内部类SingletonHolder，内部类在外部加载的时候并不会加载，
 * 在有在调用getInstance才回加载。
 * 另外SingletonHolder类使用Private修饰以确保外部类不能访问。
 *
 * @author lgq
 */
public class MultipleSingleTon {
    private MultipleSingleTon() {
    }

    private static class SingleTonHolder {
        private static MultipleSingleTon singleTon = new MultipleSingleTon();
    }

    public static MultipleSingleTon getInstance() {
        return SingleTonHolder.singleTon;
    }
}
