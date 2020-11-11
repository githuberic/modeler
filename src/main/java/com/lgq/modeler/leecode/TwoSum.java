package com.lgq.modeler.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 两数之和
 * <p>
 * 通过循环，每循环一次，将当前循环的那个数放入一个临时的 h a s h m a p hashmaphashmap数组中，
 * 其中键为当前的数，值为该数的数组下标。每循环一个数，都要在临时的那个数组中进行一个条件判断，利用c o n t a i n s K e y ( ) containsKey()containsKey() 方法判断是否存在 t a r g e t − n u m [ i ] target - num[i]target−num[i] 这个值。如果存在则输出这两个数的下标即可。
 * 这种解法的时间复杂度：O ( n ) O(n)O(n) ,空间复杂度：O ( n ) O(n)O(n)
 *
 * @author lgq
 */
public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        // 建立一个临时数组
        Map<Integer, Integer> tempArr = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 判断在数组tempArr中是否存在target - num[i]这个数
            if (tempArr.containsKey(target - arr[i])) {
                // 若存在，则返回nums[i]这个数的下标，以及target - nums[i]这个键在tempArr中所对应的值
                return new int[]{tempArr.get(target - arr[i]), i};
            } else {
                // 若不存在，则将nums[i]这个数放入tempArr中
                tempArr.put(arr[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{2, 3, 6, 4, 1, 5};
        int[] arrResult = twoSum.twoSum(arr, 8);
        if (arrResult != null) {
            for (int i = 0; i < arrResult.length; i++) {
                String str = String.format("element=%d,index=%d",arr[arrResult[i]],arrResult[i]);
                System.out.println(str);
            }
        } else {
            System.out.println("找不到想要的下标值");
        }
    }
}
