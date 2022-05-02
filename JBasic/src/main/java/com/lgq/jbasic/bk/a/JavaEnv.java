package com.lgq.jbasic.bk.a;

import java.util.Properties;

public class JavaEnv {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.forEach((o, o2) -> System.out.println("property:" + o + "=" + o2));
    }
}
