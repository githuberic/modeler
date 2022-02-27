package com.lgq.ds.linkedlist.single.extension;

import com.lgq.ds.linkedlist.single.Node;
import com.lgq.ds.linkedlist.single.util.SlUtil;

/**
 * @author lgq
 */
public class Middle<T> {
    private Node head = null;

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

    /**
     * 参考删除单链表中倒数第n个节点（JAVA）中，如果有size字段，中间节点的求法就是
     * size/2（如果有两个中间节点，取前边）
     * size/2 + 1（如果有两个中间节点，取后边）
     * 接着就是移动到相应位置即可
     *
     * 参考单链表中环的检测（JAVA）中，快慢指针的思路，二倍速的快指针走到头的时候，一倍速的慢指针就正好在中间节点了，
     * 如果有两个中间节点，取前还是后，再调（XD）
     * @return
     */
    public Node getMiddle() {
        if (head == null || head.getNext() == null) {
            return null;
        }

        Node quick = head, slow = head;
        while (quick.getNext() != null && quick.getNext().getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        Middle<String> middle = new Middle<>();
        // 初始化
        String data[] = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
        for (int i = 0; i < data.length; i++) {
            middle.insertTail(data[i]);
        }
        // 验证-输出
        System.out.println(">>>output");
        SlUtil.printAll(middle.head);

        Node nodeMiddle = middle.getMiddle();
        if (nodeMiddle != null) {
            System.out.println(">>>Middle=" + nodeMiddle.getData());
        }
    }

    // from https://blog.csdn.net/cedarjo/article/details/88557267
}
