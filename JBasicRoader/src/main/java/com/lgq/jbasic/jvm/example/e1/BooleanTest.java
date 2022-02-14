package com.lgq.jbasic.jvm.example.e1;

import org.junit.Test;

/**
 * @author lgq
 */

public class BooleanTest {
    static boolean boolValue;

    @Test
    public void testBoolean() {
        boolValue = true;
        if (boolValue) {
            System.out.println("Hello, Java!");
        }
        if (boolValue == true) {
            System.out.println("Hello, JVM!");
        }
    }
}
