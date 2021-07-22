package com.lgq.ds.queue;

/**
 * Created by eric on 2020/1/4.
 * 循环队列
 *
 * @author lgq
 */
public class CircleQueue<T> {
    private T[] array;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capacity) {
        array = (T[]) new Object[capacity];
        n = capacity;
    }

    public boolean enQueue(T element) {
        if ((tail + 1) % n == head) {
            return false;
        }
        array[tail] = element;
        tail = (tail + 1) % n;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T deQueue() {
        if (tail == head) {
            return null;
        }
        T t = array[head];
        head = (head + 1) % n;
        return t;
    }

    public void output() {
        if (n == 0) {
            return;
        }

        for (int i = head; i % n != tail; ++i) {
            System.out.println(array[i] + "");
        }
    }

    public static void main(String[] args) throws Exception {
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
