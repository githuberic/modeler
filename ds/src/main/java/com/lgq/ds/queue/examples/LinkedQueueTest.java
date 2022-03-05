package com.lgq.ds.queue.examples;

import org.junit.Test;

public class LinkedQueueTest {
    @Test
    public void testLQ() {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("a1");
        linkedQueue.enqueue("a2");
        linkedQueue.enqueue("a3");
        linkedQueue.enqueue("a4");
        linkedQueue.enqueue("a5");
        linkedQueue.enqueue("a6");
        linkedQueue.printAll();
        String dequeue = linkedQueue.dequeue();
        System.out.print(">>>Dequeue=" + dequeue);
    }
}
