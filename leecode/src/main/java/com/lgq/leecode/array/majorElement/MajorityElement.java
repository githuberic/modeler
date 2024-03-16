package com.lgq.leecode.array.majorElement;

/**
 * @author lgq
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arrNum = new int[]{3, 2, 3, 4, 5, 1, 3, 6};
        int result1 = majorityElement(arrNum);
        System.out.println("多数元素为：" + result1);
    }

    private static int majorityElement(int[] arr) {
        int count = 0;
        int majority = 0;

        for (int item : arr) {
            if (count == 0) {
                majority = item;
                count++;
            } else if (item == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
