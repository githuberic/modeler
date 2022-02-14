package com.lgq.jbasic.bk.finale.example.e2;

/**
 * @author lgq
 */
public class MThreadFinal {
    private int x;
    private final int y;
    private static MThreadFinal mThreadFinal;

    public MThreadFinal() {
        this.x = 1;
        this.y = 2;
    }

    public static void writer() {
        mThreadFinal = new MThreadFinal();
    }

    public static void reader() {
        MThreadFinal temp = mThreadFinal;
        int x1 = temp.x;
        int y1 = temp.y;
    }

    public static void main(String[] args) {
        Thread thd2 = new Thread(() -> writer());
        Thread thd1 = new Thread(() -> reader());

        thd1.start();
        thd2.start();
    }
}
