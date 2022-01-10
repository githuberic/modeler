package com.lgq.modeler.performance;

/**
 * @author lgq
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fibonacci(34));

    }

    static int fibonacci(int i) {
        if (i < 2) {
            return i;
        }
        return fibonacci(i - 2) + fibonacci(i - 1);
    }
}
