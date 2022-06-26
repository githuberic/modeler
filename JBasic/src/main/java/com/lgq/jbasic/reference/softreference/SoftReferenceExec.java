package com.lgq.jbasic.reference.softreference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * java -Xms10m -Xmx10m SoftReferenceTest
 */
public class SoftReferenceExec {
    static class HeapObject {
        byte[] bin = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject());

        List<HeapObject> list = new ArrayList<>();
        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println(">>>List add");
            } else {
                System.out.println(">>>SoftReference GC");
                break;
            }
            System.gc();
        }
    }
}
