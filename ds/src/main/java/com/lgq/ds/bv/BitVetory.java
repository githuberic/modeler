package com.lgq.ds.bv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2019/1/27.
 */
public class BitVetory {
    private int n;
    private int[] bitArray;
    private static final int BIT_LENGTH = 32;
    private static int P;
    private static int Q;

    /**
     * 初始化位向量
     *
     * @param n
     */
    public BitVetory(int n) {
        this.n = n;
        bitArray = new int[(n - 1) / BIT_LENGTH + 1];
        init();
    }

    public int[] getBitArray() {
        return this.bitArray;
    }

    /**
     * 初始化操作
     */
    public void init() {
        for (int i = 0; i < n; i++) {
            clr(i);
        }
    }

    /**
     * 获取排序后的数组
     *
     * @return
     */
    public List<Integer> getSortedArray() {
        List<Integer> sortedArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (get(i) == 1) {
                sortedArray.add(i);
            }
        }
        return sortedArray;
    }

    /**
     * 置位操作
     *
     * @param i
     */
    public void set(int i) {
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;

        bitArray[P] |= 1 << Q;
    }

    /**
     * 置零操作
     *
     * @param i
     */
    public void clr(int i) {
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;

        bitArray[P] &= ~(1 << Q);
    }

    /**
     * 读取操作
     *
     * @param i
     * @return
     */
    public int get(int i) {
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;

        return Integer.bitCount(bitArray[P] & (1 << Q));
    }
}
