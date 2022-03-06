package com.lgq.ds.bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by eric on 2019/1/27.
 */
public class BitVetoryApp {

    public static void main(String[] args) {
        System.out.println(2 % 32);
        System.out.println((15 - 1) / 32 + 1);
        int amount = 15;
        List<Integer> randoms = getRandoms(amount);
        System.out.println("排序前数组：");

        BitVetory bitVetory = new BitVetory(amount);
        for (Integer e : randoms) {
            System.out.print(e + ",");
            bitVetory.set(e);
        }

        System.out.println("BitArray Length="+bitVetory.getBitArray().length);
        /*
        System.out.println("BitArray数组：");
        int[] bitArray = bitVetory.getBitArray();
        System.out.println(bitArray);
        */

        List<Integer> sortedArray = bitVetory.getSortedArray();
        System.out.println();
        System.out.println("排序后数组：");
        for (Integer e : sortedArray) {
            System.out.print(e + ",");
        }
    }

    private static List<Integer> getRandoms(int amount) {
        Random random = new Random(1000);

        List<Integer> randoms = new ArrayList<>();
        while (randoms.size() < (amount - 1)) {
            int element = random.nextInt(amount - 1) + 1;//element ∈  [1,amount)
            if (!randoms.contains(element)) {
                randoms.add(element);
            }
        }

        return randoms;
    }
}
