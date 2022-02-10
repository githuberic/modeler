package com.lgq.jbasic.concurrent.pb7con.DiningPhilosophersFixed;

import java.util.Random;

/**
 * @author lgq
 */
public class Philosopher extends Thread {
    private Chopstick first, second;
    private Random random;
    private int thinkCount;


    public Philosopher(Chopstick left, Chopstick right) {
        if (left.getId() < right.getId()) {
            first = left;
            second = right;
        } else {
            first = right;
            second = left;
        }
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                ++thinkCount;
                if (thinkCount % 10 == 0) {
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
                }
                // Think for a while
                Thread.sleep(random.nextInt(1000));
                // Grab first chopstick
                synchronized (first) {
                    // Grab second chopstick
                    synchronized (second) {
                        // Eat for a while
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
