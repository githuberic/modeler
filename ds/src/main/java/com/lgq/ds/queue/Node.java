package com.lgq.ds.queue;

/**
 * Created by eric on 2020/1/1.
 *
 * @author lgq
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
    }

    public Node(T value, Node<T> next) {
        this.data = value;
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
