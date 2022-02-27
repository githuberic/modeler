package com.lgq.ds.linkedlist.single.extension;


import com.lgq.ds.linkedlist.single.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eric on 2018/12/27.
 *
 * @author lgq
 */
public class HasCycle<T> {
    private Node head = null;

    public void printAll(Node head) {
        Node p = head;
        while (p != null) {
            if (p.getNext() == null) {
                System.out.print(p.getData());
            } else {
                System.out.print(p.getData() + "-->");
            }
            p = p.getNext();
        }
        System.out.println();
    }

    /**
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        Set<Node> nodes = new HashSet<>();
        Node p = head;
        while (p != null) {
            if (nodes.contains(p)) {
                return true;
            } else {
                nodes.add(p);
                p = p.getNext();
            }
        }
        return false;
    }

    /**
     * @param head
     * @return
     */
    public boolean hasCycleV2(Node head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Node quick = head, slow = head;
        while (quick != null && quick.getNext() != null) {
            slow = slow.getNext();
            quick = quick.getNext().getNext();
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建Cycle节点
     */
    public void createCycle() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(head.getNext());
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

    public static void main(String[] args) {
        HasCycle<String> singleLinkedList = new HasCycle<>();
        // 初始化
        String data[] = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
        for (int i = 0; i < data.length; i++) {
            singleLinkedList.insertTail(data[i]);
        }
        // 验证-输出
        System.out.println(">>>output");
        singleLinkedList.printAll(singleLinkedList.head);

        // Create cycle
        singleLinkedList.createCycle();
        boolean hasCycle = singleLinkedList.hasCycle(singleLinkedList.head);
        System.out.println(">>>hasCycle," + hasCycle);

        // Create cycle
        boolean hasCycleV2 = singleLinkedList.hasCycleV2(singleLinkedList.head);
        System.out.println(">>>hasCycle(V2)," + hasCycleV2);
    }

    // from https://www.cnblogs.com/keeya/p/9218352.html
}
