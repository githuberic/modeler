package com.lgq.jbasic.bk.finale.example.e2;

/**
 * @author lgq
 */
public class MThreadFinalV2 {
    private final int[] arr;
    private MThreadFinalV2 mThreadFinalV2;

    public MThreadFinalV2() {
        arr = new int[1];
        arr[0] = 2;
    }

    public void method1() {
        MThreadFinalV2 mThreadFinalV2 = new MThreadFinalV2();
        System.out.println(mThreadFinalV2.arr[0]);
    }

    public void method2() {
        arr[0] = 1;
        System.out.println(this.arr[0]);
    }

    public void method3() {
        MThreadFinalV2 mThreadFinalV21 = mThreadFinalV2;
        int temp = mThreadFinalV21.arr[0];
        System.out.println(temp);
    }

    public static void main(String[] args) {
        MThreadFinalV2 mThreadFinalV2 = new MThreadFinalV2();
        mThreadFinalV2.method1();
        mThreadFinalV2.method2();
        mThreadFinalV2.method3();
    }
}
