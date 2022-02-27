package com.lgq.ds.linkedlist.single.extension;

import com.lgq.ds.linkedlist.single.Node;
import com.lgq.ds.linkedlist.single.util.SlInsertUtil;
import com.lgq.ds.linkedlist.single.util.SlUtil;

/**
 * @author lgq
 */
public class SlRemoveNthEnd<T> {

    private Node head = null;

    public SlRemoveNthEnd(T t) {
        head = new Node(t, null);
    }

    public Node removeNthEnd(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node p = head;
        int i;
        for (i = 0; i < n; i++) {
            p = p.getNext();
            if (p == null) {
                break;
            }
        }
        // 链表长度为n时，删除头结点
        if (i == n - 1 && p == null) {
            return head.getNext();
        }
        // 如果链表长度小于n，则返回原链表
        if (i < n - 1 && p == null) {
            return head;
        }

        Node q = head;
        while (p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
        }
        q.setNext(q.getNext().getNext());
        return head;
    }

    public static void main(String[] args) {
        SlRemoveNthEnd slRemoveNthEnd = new SlRemoveNthEnd(-1);

        // 链表Header
        Node head = slRemoveNthEnd.head;

        // 初始化
        Integer[] data = {1, 2, 3, 44, 5, 66, 77, 888, 90};
        for (Integer datum : data) {
            SlInsertUtil.insertTail(head, datum);
        }

        // 验证-输出
        System.out.println(">>>output");
        SlUtil.printAll(head.getNext());

        slRemoveNthEnd.removeNthEnd(head.getNext(), 1);

        // 验证-输出
        System.out.println(">>>output.removeNthEnd");
        SlUtil.printAll(head.getNext());
    }

    //from https://blog.51cto.com/14233363/2404532, https://www.cnblogs.com/yanhowever/p/10449168.html
}
