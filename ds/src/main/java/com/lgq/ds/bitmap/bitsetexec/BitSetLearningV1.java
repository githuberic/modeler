package com.lgq.ds.bitmap.bitsetexec;

import java.util.BitSet;

/**
 * 说明默认的构造函数声明一个64位的BitSet，值都是false。<br/>
 * 如果你要用的位超过了默认size,它会再申请64位，而不是报错。
 *
 * @author lgq
 */
public class BitSetLearningV1 {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.isEmpty() + "--" + bitSet.size());
        bitSet.set(0);
        System.out.println(bitSet.isEmpty() + "--" + bitSet.size());
        bitSet.set(1);
        System.out.println(bitSet.isEmpty() + "--" + bitSet.size());
        System.out.println(bitSet.get(65));
        bitSet.set(65);
        System.out.println(bitSet.isEmpty() + "--" + bitSet.size());
    }
}
