package com.lgq.leecode.map.intersection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lgq
 */
public class Intersection2IntArr {

    public static void main(String[] args) {
        int a[] = {4, 9, 5};
        int b[] = {9, 4, 9, 8, 4};

        int[] arrIntersection = intersection(a, b);
        for (int item : arrIntersection) {
            System.out.print(item + ",");
        }
    }

    private static int[] intersection(int[] arrA, int[] arrB) {
        if (arrA == null || arrA.length == 0 || arrB == null || arrB.length == 0) {
            return new int[0];
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setRest = new HashSet<>();

        for (int item : arrA) {
            setA.add(item);
        }

        for (int item : arrB) {
            if (setA.contains(item)) {
                setRest.add(item);
            }
        }

        int[] arrRet = new int[setRest.size()];
        int j = 0;
        for (int item : setRest) {
            arrRet[j++] = item;
        }
        return arrRet;
    }
}
