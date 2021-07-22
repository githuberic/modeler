package com.lgq.ds.queue;

/**
 * 循环队列
 * Created by eric on 2018/12/30.
 */
public class LoopArrayQueue {
    //存储数据的数组
    private String[] items;
    //记录数组容量
    private int n;
    private int size = 0;
    //head记录队头索引，tail记录队尾索引
    private int head = 0;
    private int tail = 0;

    //申请一个指定容量的队列
    public LoopArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队：关键在于队满的条件
    // 这里讲一下，这个表达式是怎么来的。在一般情况下，我们可以看出来，当队列满时，tail+1=head。但是，有个特殊情况，就是tail=n-1，而head=0时，这时候，tail+1=n，而head=0，所以用(tail+1)%n == n%n == 0。而且，tail+1最大的情况就是 n ，不会大于 n，这样，tail+1 除了最大情况，不然怎么余 n 都是 tail+1 本身，也就是 head。这样，表达式就出现了。
    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        size++;
        return true;
    }

    //出队：关键在于队空的条件
    public String dequeue() {
        String res = null;
        if (head == tail) {
            return res;
        }
        res = items[head];
        head = (head + 1) % n;
        size--;
        return res;
    }
}
