package com.lgq.modeler.ds.list.single.util;

import com.lgq.modeler.ds.list.Node;

/**
 * @author lgq
 */
public class SlUtil {
    public static void printAll(Node head) {
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
}
