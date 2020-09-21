package com.lgq.modeler.bk.bit;

/**
 * 移位技巧相关
 * Created by eric on 2019/11/6.
 *
 * @@author lgq
 */
public class MoveBitSkill {
    public static void main(String[] args) {
        // 1. 获得int型最大值；2147483647的十六进制为0x7FFFFFFF,其中最高位为符号位
        System.out.println((1 << 31) - 1);// 2147483647， 由于优先级关系，括号不可省略
        System.out.println(~(1 << 31));// 2147483647
    }
}
