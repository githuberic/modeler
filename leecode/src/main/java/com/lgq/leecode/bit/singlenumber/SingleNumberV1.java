package com.lgq.leecode.bit.singlenumber;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lgq
 */
public class SingleNumberV1 {

    public static void main(String[] args) {
        // 输入数组
        int[] nums = {1, 2, 1, 2, 3, 3, 4};

        int singleNum = singleNumber(nums);
        singleNum = singleNumberV2(nums);

        System.out.println(">>>只出现一次的数字=" + singleNum);
    }

    private static int singleNumber(int[] arr) {
        HashMap<Integer, Integer> hashSet = new HashMap<>();

        for (int j : arr) {
            //将数组中的所有元素添加到 hashMap 中，键/值为元素值/该元素出现的次数
            hashSet.put(j, hashSet.getOrDefault(j, 0) + 1);
        }

        for (Integer i : hashSet.keySet()) {
            if (hashSet.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    private static int singleNumberV2(int[] arr) {
        int single = 0;

        for (int item : arr) {
            single ^=item;
        }
        return single;
    }
}
