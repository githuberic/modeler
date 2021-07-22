package com.lgq.ds.queue;

/**
 * Created by eric on 2018/12/30.
 *
 * @author lgq
 */
public class LinkedQueue<T> {
    // head指向队头结点，tail指向队尾节点
    private Node head;
    private Node tail;

    // 申请一个队列
    public LinkedQueue() {
    }

    // 入队
    public boolean enqueue(T t) {
        Node newNode = new Node(t, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        return true;
    }

    //出队
    public T dequeue() {
        T res = null;
        if (head == null) {
            return res;
        }
        res = (T) head.getData();
        if (head == null) {
            tail = null;
        }
        return res;
    }

    public void printAll() {
        Node p = this.head;
        while (p != null) {
            System.out.println(">>>Node value=" + p.getData());
            p = p.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
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
