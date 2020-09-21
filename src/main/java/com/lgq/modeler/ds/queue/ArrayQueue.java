package com.lgq.modeler.ds.queue;

/**
 * Created by eric on 2018/12/30.
 */
public class ArrayQueue {
    //存储数据的数组
    private String[] items;
    //记录数组容量
    private int n;
    private int size;
    //head记录队头索引，tail记录队尾索引
    private int head = 0;
    private int tail = 0;

    //申请一个指定容量的队列
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /*
    * 入队：
    * 1.堆满的时，入队失败
    * 1.1频繁出入队，造成数组使用不连续
    * 1.2在入队的时候，集中触发进行数据搬移
    * 2.在末尾插入数据，注意tail指向队尾元素的索引+1
    */
    public boolean enqueue(String item) {
        //表示队满
        if (head == 0 && tail == n) {
            return false;
        }
        //表示需要数据搬移
        else if (head != 0 && tail == n) {
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            head = 0;
            tail = tail - head;
        }
        //将数据加入队列
        items[tail++] = item;
        size++;
        return true;
    }

    //出队：1.队空时，出队失败;2.出队，head索引+1
    public String dequeue() {
        String res = null;
        if (head == tail) {
            return res;
        }
        res = items[head++];
        size--;
        return res;
    }
}
