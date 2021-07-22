package com.lgq.ds.stack;

/**
 * @author lgq
 */
public class LinkedListBasedStack<T> {
    private int size;
    private Node top;

    public Node createNode(T t, Node node) {
        return new Node(t, node);
    }

    public void clear() {
        this.size = 0;
        top = null;
    }

    public void push(T t) {
        Node node = createNode(t, this.top);
        this.top = node;
        this.size++;
    }

    public T pop() {
        Node popNode = this.top;
        if (popNode == null) {
            System.out.println("Stack is empty.");
            return null;
        }

        this.top = popNode.getNext();
        if (this.size > 0) {
            this.size--;
        }
        return (T) popNode.getData();
    }

    public int getSize() {
        return this.size;
    }

    public T getTopData() {
        if (this.top == null) {
            return null;
        }
        return (T) this.top.getData();
    }

    public void printAll() {
        System.out.println("Print stack:");
        Node popNode = this.top;
        while (popNode != null) {
            System.out.print((T) popNode.getData() + "\t");
            popNode = popNode.getNext();
        }
        System.out.println();
    }
}
