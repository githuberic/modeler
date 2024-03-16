package com.lgq.leecode.list;

/**
 * @author lgq
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + value + ", next=" + next + "]";
    }

    public void printAll() {
        String str = "(value = " + value;
        ListNode p = next;
        while (p != null) {
            str += ", nextValue = " + p.value;
            p = p.next;
        }
        str += ")";
        System.out.println(str);
    }
}
