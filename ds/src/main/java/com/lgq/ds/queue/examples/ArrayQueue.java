package com.lgq.ds.queue.examples;

/**
 * Created by eric on 2018/12/30.
 *
 * @author lgq
 */
public class ArrayQueue<T> {
    /**
     * 存储数据的数组
     */
    private T[] items;
    /**
     * 记录数组容量
     */
    private int size;
    /**
     * head记录队头索引，tail记录队尾索引
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个指定容量的队列
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        size = capacity;
    }

    /*
     * 入队：
     * 1.堆满的时，入队失败
     * 1.1频繁出入队，造成数组使用不连续
     * 1.2在入队的时候，集中触发进行数据搬移
     * 2.在末尾插入数据，注意tail指向队尾元素的索引+1
     */
    public boolean enqueue(T item) {
        if (tail == size) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public boolean enqueueV2(T t) {
        // tail == size表示队列末尾没有空间了
        if (tail == size) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = t;
        tail++;
        return true;
    }

    //出队：1.队空时，出队失败;2.出队，head索引+1
    public T dequeue() {
        T res = null;
        if (head == tail) {
            return res;
        }
        res = items[head++];
        size--;
        return res;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
