package com.lgq.ds.queue.examples;

import org.junit.Test;

/**
 * @author lgq
 */
public class CircleQueueTest {
    @Test
    public void testCQ() {
        CircleQueue<String> circleQueue = new CircleQueue<>(6);
        circleQueue.enQueue("a1");
        circleQueue.enQueue("a2");
        circleQueue.enQueue("a3");
        circleQueue.enQueue("a4");
        circleQueue.enQueue("a5");
        circleQueue.enQueue("a6");
        circleQueue.enQueue("a7");
        circleQueue.output();
        circleQueue.deQueue();

        circleQueue.output();
    }
}
