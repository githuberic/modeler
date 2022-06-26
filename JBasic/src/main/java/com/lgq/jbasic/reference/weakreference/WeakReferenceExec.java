package com.lgq.jbasic.reference.weakreference;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class WeakReferenceExec {
    static class MyObject {
    }

    public static void main(String[] args) throws Exception {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());

        System.out.println(weakReference.get() == null);//false

        System.gc();
        TimeUnit.SECONDS.sleep(1);//暂停一秒钟
        System.out.println(weakReference.get() == null);//true
    }
}
