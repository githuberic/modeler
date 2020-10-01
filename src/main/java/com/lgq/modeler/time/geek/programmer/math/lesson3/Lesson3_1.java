package com.lgq.modeler.time.geek.programmer.math.lesson3;

/**
 * @author lgq
 */
public class Lesson3_1 {
    public static long getNumberOfWheat(int grid) {
        long sum = 0;
        long numOfWheatInGrid = 0;

        numOfWheatInGrid = 1;
        sum += numOfWheatInGrid;

        for (int i = 2; i <= grid; i++) {
            numOfWheatInGrid *= 2;
            sum += numOfWheatInGrid;
        }

        return sum;
    }

    public static void mainV1(String[] args) {
        System.out.println(String.format("舍罕王给了这么多粒：%d",   Lesson3_1.getNumberOfWheat(63)));
    }


    public static void main(String[] args) {
        int grid = 63;
        long start, end = 0;
        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", Lesson3_1.getNumberOfWheat(grid)));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", (long)(Math.pow(2, grid)) - 1));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));
    }
}
