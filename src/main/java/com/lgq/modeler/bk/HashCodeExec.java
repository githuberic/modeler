package com.lgq.modeler.bk;

/**
 * Created by eric on 2019/1/7.
 *
 * @author shaofeng
 */
public class HashCodeExec {
    public static void main(String[] args) {
        temp();
    }

    private static void temp() {
        int i = 4;
        int val1 = 31 * i;
        int val2 = (i << 5) - i;
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val1==val2);
    }
}
