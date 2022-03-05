package com.lgq.ds.queue.examples;

import org.junit.Test;

public class ArrayQueueTest {
    @Test
    public void testAQ() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(6);
        arrayQueue.enqueue("a1");
        arrayQueue.enqueue("a2");
        arrayQueue.enqueue("a3");
        arrayQueue.enqueue("a4");
        arrayQueue.enqueue("a5");
        arrayQueue.enqueue("a6");
        arrayQueue.printAll();
        String dequeue = arrayQueue.dequeue();
        System.out.print(">>>Dequeue=" + dequeue);
    }
}
