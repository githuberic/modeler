package com.lgq.modeler.ds.queue;

/**
 * @author lgq
 */
public class DynamicArrayQueue<T> {
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
    public DynamicArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        size = capacity;
    }

    public boolean enqueue(T t) {
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

    public static void main(String[] args) {
        DynamicArrayQueue<String> dynamicArrayQueue = new DynamicArrayQueue<>(6);
        dynamicArrayQueue.enqueue("a1");
        dynamicArrayQueue.enqueue("a2");
        dynamicArrayQueue.enqueue("a3");
        dynamicArrayQueue.enqueue("a4");
        dynamicArrayQueue.enqueue("a5");
        dynamicArrayQueue.enqueue("a6");
        dynamicArrayQueue.printAll();
        String dequeue = dynamicArrayQueue.dequeue();
        System.out.print(">>>Dequeue=" + dequeue);
    }
}
