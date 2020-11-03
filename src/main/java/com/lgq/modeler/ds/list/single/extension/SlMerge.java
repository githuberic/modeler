package com.lgq.modeler.ds.list.single.extension;

import com.lgq.modeler.ds.list.Node;
import com.lgq.modeler.ds.list.single.util.SlInsertUtil;
import com.lgq.modeler.ds.list.single.util.SlUtil;

/**
 * @author lgq
 */
public class SlMerge {

    private Node head;

    public SlMerge() {
        head = new Node();
    }

    public Node merge(Node<Integer> first, Node<Integer> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.getData() == null) {
            first = first.getNext();
        }
        if (second.getData() == null) {
            second = second.getNext();
        }

        if (first.getData() < second.getData()) {
            first.setNext(merge(first.getNext(), second));
            return first;
        } else {
            second.setNext(merge(first, second.getNext()));
            return second;
        }
    }

    public Node mergeV2(Node<Integer> first, Node<Integer> second) {
        Node preHead = new Node(-1, null);
        Node head = preHead;

        while (first != null && second != null) {
            if (first.getData() == null) {
                first = first.getNext();
            }
            if (second.getData() == null) {
                second = second.getNext();
            }
            if (first.getData() < second.getData()) {
                head.setNext(first);
                first = first.getNext();
            } else {
                head.setNext(second);
                second = second.getNext();
            }
            head = head.getNext();
        }
        head.setNext(first == null ? second : first);
        return preHead.getNext();
    }

    public static void main(String[] args) {
        SlMerge slMergeV1 = new SlMerge();
        // 初始化
        Integer[] data = {1, 2, 3};
        for (Integer datum : data) {
            SlInsertUtil.insertTail(slMergeV1.head, datum);
        }

        SlMerge slMergeV2 = new SlMerge();
        // 初始化
        Integer[] dataV2 = {4, 5, 6};
        for (Integer integer : dataV2) {
            SlInsertUtil.insertTail(slMergeV2.head, integer);
        }

        SlMerge merge = new SlMerge();
        merge.head = merge.merge(slMergeV1.head, slMergeV2.head);
        //merge.head = merge.mergeV2(slMergeV1.head, slMergeV2.head);
        // 验证-输出
        System.out.println(">>>output");
        SlUtil.printAll(merge.head);
    }
    // from https://www.cnblogs.com/youdiaodaxue16/p/10771809.html
    //https://blog.csdn.net/weixin_45625687/article/details/107940853
}
