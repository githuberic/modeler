package com.lgq.modeler.bk;

/**
 * Created by eric on 2019/4/16.
 *
 * @author shaofengs
 */
public class SystemPropTest {
    private static void setValue() {
        System.setProperty("name", "韶峰");
        System.setProperty("age", "18");
    }

    static {
        setValue();
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("age"));
    }
}

