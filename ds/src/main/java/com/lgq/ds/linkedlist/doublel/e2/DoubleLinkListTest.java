package com.lgq.ds.linkedlist.doublel.e2;

import org.junit.Test;

public class DoubleLinkListTest {
    @Test
    public void testDL() {
        DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.insertInto("a1");
        doubleLinkList.insertInto("a2");
        doubleLinkList.insertInto("a3");
        doubleLinkList.insertInto("a4");
        doubleLinkList.insertInto("a5");
        doubleLinkList.insert("a6",1);
        Node node = doubleLinkList.getNode(1);
        if (node != null) {
            System.out.println(node.value);
        }
    }
}
