package com.lgq.jbasic.concurrent.pb7con.DiningPhilosophersTimeout;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lgq
 */
public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[5];
        ReentrantLock[] chopsticks = new ReentrantLock[5];

        for (int i = 0; i < 5; ++i) {
            chopsticks[i] = new ReentrantLock();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; ++i) {
            philosophers[i].join();
        }
    }
}
