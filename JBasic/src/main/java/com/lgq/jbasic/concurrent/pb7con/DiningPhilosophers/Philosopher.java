package com.lgq.jbasic.concurrent.pb7con.DiningPhilosophers;

import java.util.Random;

/**
 * @author lgq
 */
class Philosopher extends Thread {
    private Chopstick left, right;
    private Random random;
    private int thinkCount;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
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
                Thread.sleep(random.nextInt(1000));     // Think for a while
                synchronized (left) {                    // Grab left chopstick
                    synchronized (right) {                 // Grab right chopstick
                        Thread.sleep(random.nextInt(1000)); // Eat for a while
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
