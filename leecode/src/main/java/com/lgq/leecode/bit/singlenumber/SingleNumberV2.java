package com.lgq.leecode.bit.singlenumber;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lgq
 * from : https://blog.csdn.net/weixin_43004044/article/details/126020515
 */
public class SingleNumberV2 {

    public static void main(String[] args) {
        // 输入数组
        int[] nums = {1, 2, 2, 2, 3, 3, 3};

        //int singleNum = singleNumber(nums);
        int singleNum = singleNumberV2(nums);

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
        HashSet<Integer> hashSet = new HashSet<>();
        long sum = 0;
        for (int item : arr) {
            hashSet.add(item);
            sum += (long) item;
        }

        long setSum = 0;
        for (Integer item : hashSet) {
            setSum += (long) item;
        }

        return (int) ((setSum * 3 - sum) / 2);
    }

    private static int singleNumberV3(int[] arr) {
        int single = 0;

        for (int item : arr) {
            single ^= item;
        }
        return single;
    }
}
