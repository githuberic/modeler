package com.lgq.modeler.ds.list.single.v2;

/**
 * Created by eric on 2018/12/27.
 *
 * @author lgq
 */
public class SingleLinkedList {
    private Node head = null;

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p) {
        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;
        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);
            Cur = next;
        }
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return Head;
    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while (r != p) {
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
