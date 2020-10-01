package com.lgq.modeler.ds.list.v1;

import com.lgq.modeler.ds.list.Node;

/**
 * Created by eric on 2020/1/1. 单链表
 *
 * @author lgq
 */
public class SingleList<T> {

    /**
     * 头节点指针
     */
    private Node<T> header;
    /**
     * 尾节点指针
     */
    private Node<T> last;
    /**
     * 实际长度
     */
    private int size;

    public SingleList() {
        header = new Node<>();
        last = header;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> select(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出list节点范围");
        }

        Node<T> node = header;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node<T> node = select(index);
        return node.getData();
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        last.setNext(node);
        last = node;
        size++;
    }

    /**
     * 链表插入元素
     *
     * @param t     插入的元素
     * @param index 插入的位置
     * @throws Exception
     */
    public void add(T t, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出list节点范围");
        }

        Node<T> node = new Node<>(t);
        if (size == 0) {
            header = last = node;
        } else if (index == 0) {
            node.setNext(header);
            header = node;
        } else if (index == size - 1) {
            last.setNext(node);
            last = node;
        } else {
            // 插入中间
            // 找到index前一个节点
            Node<T> preNode = select(index - 1);
            node.setNext(preNode.getNext());
            preNode.setNext(node);
        }
        size++;
    }

    public Node<T> remove(int index) throws Exception {
        if (size == 0) {
            throw new IllegalArgumentException("List is null");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出list节点范围");
        }

        Node rNode;
        if (index == 0) {
            rNode = header;
            header = header.getNext();
        } else if (index == size - 1) {
            Node<T> preNode = select(index - 1);
            rNode = preNode.getNext();
            preNode.setNext(null);
            last = preNode;
        } else {
            Node<T> preNode = select(index - 1);
            // preNode.getNext()就是待移除的节点
            rNode = preNode.getNext();
            Node nodeNext = preNode.getNext().getNext();
            preNode.setNext(nodeNext);
        }
        size--;
        return rNode;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node<T> node = header;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<>();
        try {
            System.out.println("Add element>>>");
            singleList.add(3, 0);
            singleList.add(7, 1);
            singleList.add(9, 2);
            singleList.add(5, 3);
            singleList.add(1, 2);
            singleList.output();
            System.out.println("Remove element>>>");
            singleList.remove(1);
            singleList.output();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
