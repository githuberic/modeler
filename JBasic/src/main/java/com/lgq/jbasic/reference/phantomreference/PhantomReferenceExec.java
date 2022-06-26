package com.lgq.jbasic.reference.phantomreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExec {
    static class MyObject {

    }

    public static void main(String[] args) {
        ReferenceQueue<MyObject> queue = new ReferenceQueue<>();

        PhantomReference<MyObject> phantomReference = new PhantomReference<>(new MyObject(), queue);
        System.out.println(phantomReference.get() == null);//true
    }
}
