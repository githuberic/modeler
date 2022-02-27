package com.lgq.ds.linkedlist.single;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void testSL() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        // 初始化
        String data[] = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
        for (int i = 0; i < data.length; i++) {
            singleLinkedList.insertTail(data[i]);
        }

        // 验证-输出
        System.out.println(">>>output");
        singleLinkedList.printAll();

        Node node = singleLinkedList.findByIndex(2);
        if (node != null) {
            System.out.println(">>>findByIndex,data=" + node.getData());
        }
        node = singleLinkedList.findByValue("a1");
        if (node != null) {
            System.out.println(">>>findByValue,data=" + node.getData());
        }

        singleLinkedList.insertBefore(new Node("a4", null), new Node("a44", null));
        System.out.println(">>>output-insertBefore(a4)");
        singleLinkedList.printAll();
        singleLinkedList.insertBefore(new Node("a1", null), new Node("a0", null));
        System.out.println(">>>output-insertBefore(a1)");
        singleLinkedList.printAll();

        singleLinkedList.deleteByNode(new Node("a44", null));
        System.out.println(">>>output-deleteByNode(a44)");
        singleLinkedList.printAll();

        singleLinkedList.deleteByValue("a1");
        System.out.println(">>>output-deleteByValue(a1)");
        singleLinkedList.printAll();
    }
}
