package com.lgq.jbasic.jvm.example.e1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class FooUnsafe {
    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FooUnsafe foo = new FooUnsafe();
        Field field = foo.getClass().getDeclaredField("flag");

        Unsafe unsafe = getUnsafe();
        long offset = unsafe.objectFieldOffset(field);
        unsafe.putInt(foo, offset, 3);
        if (foo.getFlag()) {
            System.out.println("Hello,Java");
        }
        if (foo.getFlag() == true) {
            System.out.println("Hello, JVM");
        }
    }
}