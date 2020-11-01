package com.lgq.modeler.ds.list.single.util;

import com.lgq.modeler.ds.list.Node;

/**
 * @author lgq
 */
public class SlInsertUtil {
    /**
     * 尾部插入
     *
     * @param value
     */
    public static <T> void insertTail(Node<T> head, T value) {
        if (head == null) {
            return;
        }
        Node newNode = new Node(value, null);

        // 空链表，可以插入新节点作为head，也可以不操作
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
}
