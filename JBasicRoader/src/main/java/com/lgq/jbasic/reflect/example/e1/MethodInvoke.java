package com.lgq.jbasic.reflect.example.e1;

/**
 * Created by eric on 2019/11/10.
 *
 * @author lgq
 */
public class MethodInvoke {
    public void print() {
        System.out.println("Hello World");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public String print(String str) {
        return str.toLowerCase();
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
