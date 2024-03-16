package com.lgq.leecode.bit.singlenumber;

import java.util.HashMap;
import java.util.HashSet;

public class SingleNumberV3 {
    public static void main(String[] args) {
        // 输入数组
        int[] nums = {1, 2, 2, 4, 4, 3, 3, 5};

        int[] singleNum = singleNumber(nums);

        for (int val : singleNum) {
            System.out.println(">>>只出现一次的数字=" + val);
        }
    }

    private static int[] singleNumber(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int item : arr) {
            //将数组中的所有元素添加到 hashMap 中，键/值为元素值/该元素出现的次数
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1);
        }

        int cnt = 0;
        int[] res = new int[2];
        for (Integer i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) {
                res[cnt++] = i;
            }
        }
        return res;
    }
}
