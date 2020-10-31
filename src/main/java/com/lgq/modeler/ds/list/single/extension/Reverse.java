package com.lgq.modeler.ds.list.single.extension;

import com.lgq.modeler.ds.list.Node;

/**
 * Created by eric on 2018/12/27.
 *
 * @author lgq
 */
public class Reverse<T> {
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
    
    public Node reverseV2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node next = head.getNext();
        Node revHead = reverseV2(next);
        /*
        接下来就是弹栈过程了
        1:程序继续执行 temp.next = head就相当于4->3
        2:head.next = null 即把3结点指向4结点的指针断掉。
        3:返回新链表的头结点newHead
        */
        next.setNext(head);
        head.setNext(null);
        return revHead;
    }

    /**
     * 所谓的单链表反转就是将链表的指针方向改变。但是，由于单链表没有指向前一个结点的指针，
     * 所以我们定义一个指向前一个结点的指针pre，用于存储每一个节点的前一个结点。
     * 接下来还需要定义一个保存当前结点的指针cur，以及下一个节点的next。
     * 定义好之后，遍历单链表，将当前结点的指针指向前一个结点，之后定义三个指针向后移动，直至遍历到最后一个结点为止。
     *
     * @param node
     * @return
     */
    public Node reverse(Node node) {
        //前一个节点指针
        Node pre = null;
        //当前节点指针
        Node cur = head;
        //下一个节点指针
        Node next = null;
        while (cur != null) {
            // nextNode 指向下一个节点
            next = cur.getNext();
            // 将当前节点next域指向前一个节点
            cur.setNext(pre);
            // preNode 指针向后移动
            pre = cur;
            // curNode指针向后移动
            cur = next;
        }
        return pre;
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
        Reverse<String> reverse = new Reverse<>();
        // 初始化
        String data[] = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
        for (int i = 0; i < data.length; i++) {
            reverse.insertTail(data[i]);
        }
        // 验证-输出
        System.out.println(">>>output");
        reverse.printAll(reverse.head);

        Node nodeReverse = reverse.reverse(reverse.head);
        System.out.println(">>>output.reverse");
        reverse.printAll(nodeReverse);
    }

    // from https://www.cnblogs.com/keeya/p/9218352.html
}
