package com.lgq.leecode.list.merge2wolist1;

import com.lgq.leecode.list.ListNode;

/**
 * @author lgq
 */
public class Merge2SortedList1 {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode first1 = new ListNode(2);
        ListNode first2 = new ListNode(3);
        first.next = first1;
        first1.next = first2;

        ListNode second = new ListNode(4);
        ListNode second1 = new ListNode(5);
        ListNode second2 = new ListNode(6);
        second.next = second1;
        second1.next = second2;

        ListNode merge = merge(first, second);
        merge.printAll();
    }

    private static ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        if (listNode1.value < listNode2.value) {
            listNode1.next = merge(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = merge(listNode1, listNode2.next);
            return listNode2;
        }
    }
}
