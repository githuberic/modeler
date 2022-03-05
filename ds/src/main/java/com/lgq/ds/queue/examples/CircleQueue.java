package com.lgq.ds.queue.examples;

/**
 * Created by eric on 2020/1/4.
 * 循环队列
 *
 * @author lgq
 */
public class CircleQueue<T> {
    private T[] array;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capacity) {
        array = (T[]) new Object[capacity];
        size = capacity;
    }

    public boolean enQueue(T element) {
        if ((tail + 1) % size == head) {
            return false;
        }
        array[tail] = element;
        tail = (tail + 1) % size;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T deQueue() {
        if (tail == head) {
            return null;
        }
        T t = array[head];
        head = (head + 1) % size;
        return t;
    }

    public void output() {
        if (size == 0) {
            return;
        }

        for (int i = head; i % size != tail; ++i) {
            System.out.println(array[i] + "");
        }
    }
}
