package com.lgq.modeler.bk.mem;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by eric on 2019/12/13.
 * VM args:-Xmx5M --XX:MaxDirectMemorySize=5M
 * <p>
 * 本机直接内存溢出
 * <p>
 * Unsafe提供的直接内存访问的方法中使用的内存不受JVM管理(无法被GC)
 *
 * @author lgq
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Throwable {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
