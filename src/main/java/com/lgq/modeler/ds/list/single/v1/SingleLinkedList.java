package com.lgq.modeler.ds.list.single.v1;

import com.lgq.modeler.ds.list.Node;

/**
 * Created by eric on 2018/12/27.
 *
 * @author lgq
 */
public class SingleLinkedList<T> {
    private Node head = null;

    public Node findByValue(T value) {
        Node p = head;
        while (p != null && p.getData().equals(value)) {
            p = p.getNext();
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            ++pos;
        }
        return p;
    }

    public void insertToHead(Node newNode) {
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void insertToHead(T value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    /**
     * 尾部插入
     *
     * @param value
     */
    public void insertTail(T value) {
        Node newNode = new Node(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;
        } else {
            // 查询最后一个节点node
            Node q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }
            newNode.setNext(q.getNext());
            q.setNext(newNode);
        }
    }

    public void insertAfter(Node p, T value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null || head == null) {
            return;
        }

        // 寻找p之前的node
        Node preP = head;
        while (preP != null && !preP.getNext().getData().equals(p.getData())) {
            preP = preP.getNext();
        }
        if (preP == null) {
            return;
        }

        newNode.setNext(preP.getNext());
        preP.setNext(newNode);
    }

    public void insertBefore(Node p, T value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        // 寻找p之前的node
        Node preP = head;
        while (preP != null && !preP.getNext().getData().equals(p.getData())) {
            preP = preP.getNext();
        }
        if (preP == null) {
            return;
        }

        p.setNext(preP.getNext().getNext());
        newNode.setNext(p);
        preP.setNext(newNode);
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.getNext();
            return;
        }

        Node preP = head;
        while (preP != null && !preP.getNext().getData().equals(p.getData())) {
            preP = preP.getNext();
        }
        if (preP == null) {
            return;
        }

        preP.setNext(preP.getNext().getNext());
    }

    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }

        Node pNode = head;
        while (pNode != null) {
            if (pNode.getNext() != null && pNode.getNext().getData().equals(value)) {
                pNode.setNext(pNode.getNext().getNext());
                continue;
            }
            pNode = pNode.getNext();
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        String data[] = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a7"};

        for (int i = 0; i < data.length; i++) {
            singleLinkedList.insertTail(data[i]);
        }
        // 输出
        System.out.println(">>>output");
        singleLinkedList.printAll();

        singleLinkedList.insertBefore(new Node("a4", null), new Node("a44", null));
        System.out.println(">>>output");
        singleLinkedList.printAll();

        singleLinkedList.deleteByNode(new Node("a44", null));
        System.out.println(">>>output");
        singleLinkedList.printAll();

        singleLinkedList.deleteByValue("a7");
        System.out.println(">>>output");
        singleLinkedList.printAll();
    }
}
