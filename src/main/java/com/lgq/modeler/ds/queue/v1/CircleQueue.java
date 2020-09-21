package com.lgq.modeler.ds.queue.v1;

/**
 * Created by eric on 2020/1/4.
 * 循环队列
 *
 * @author lgq
 */
public class CircleQueue<T> {
    private T[] array;
    private int front;
    private int rear;

    public CircleQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void enQueue(T element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("Queue is full");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public T deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("Queue is empty");
        }
        T t = array[front];
        front = (front + 1) % array.length;
        return t;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i].toString());
        }
    }

    public static void main(String[] args) throws Exception {
        CircleQueue<String> circleQueue = new CircleQueue<>(6);
        circleQueue.enQueue("a");
        circleQueue.enQueue("b");
        circleQueue.enQueue("c");
        circleQueue.deQueue();
        circleQueue.enQueue("d");
        circleQueue.deQueue();

        circleQueue.output();
    }
}
