package com.lgq.jbasic.reference.softreference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class SoftReferenceQueueExec {
    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        ReferenceQueue<HeapObject> queue = new ReferenceQueue<>();
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject(), queue);

        List<HeapObject> list = new ArrayList<>();

        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println(">>>List.add");
            } else {
                System.out.println(">>>Soft refer GC");
                break;
            }
            System.gc();
        }

        // 那么当这个SoftReference所软引用的HeapObject 被垃圾收集器回收的同时，SoftReference对象被列入ReferenceQueue。
        // 也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象（HeapObject ）的Reference对象。
        Reference<? extends HeapObject> pollRef = queue.poll();
        while (pollRef != null) {
            System.out.println(pollRef);
            System.out.println(pollRef.get());
            pollRef = queue.poll();
        }
    }
}
