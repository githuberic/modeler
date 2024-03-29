package com.lgq.ds.linkedlist.single.e1;

import com.lgq.ds.linkedlist.single.Node;

/**
 * @author lgq
 */
public class SingleLinkedList<T> {
    private Node head = null;

    public Node createNode(int value) {
        return new Node(value, null);
    }

    public Node findByValue(T value) {
        if (value == null) {
            return null;
        }

        Node p = head;
        while (p != null && !p.getData().equals(value)) {
            p = p.getNext();
        }
        return p;
    }

    public Node findByIndex(int index) {
        if (index < 0) {
            return null;
        }

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
        if (value == null) {
            return;
        }

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
        if (p == null || newNode == null) {
            return;
        }

        // 判定是否在head插入
        if (head.getData().equals(p.getData())) {
            insertToHead(newNode);
            return;
        }

        // 寻找p之前的node
        Node pre = head;
        while (pre != null && !pre.getNext().getData().equals(p.getData())) {
            pre = pre.getNext();
        }
        if (pre == null) {
            return;
        }

        newNode.setNext(pre.getNext());
        pre.setNext(newNode);
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.getNext();
            return;
        }

        // preP 节点p的前一个节点
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
            // 删除的head
            if (pNode.getData().equals(value)) {
                pNode = pNode.getNext();
            } else {
                // 删除的非head
                if (pNode.getNext() != null && pNode.getNext().getData().equals(value)) {
                    pNode.setNext(pNode.getNext().getNext());
                    continue;
                }
                pNode = pNode.getNext();
            }
        }
    }

    public void deleteByValueV1(T value) {
        if (head == null) {
            return;
        }

        for (Node pNode = head; pNode != null; pNode = pNode.getNext()) {
            if (pNode.getData().equals(value)) {
                pNode = pNode.getNext();
            }
            if (pNode.getNext() != null && pNode.getNext().getData().equals(value)) {
                pNode.setNext(pNode.getNext().getNext());
                continue;
            }
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
}
