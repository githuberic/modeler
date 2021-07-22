package com.lgq.leecode;

/**
 * 合并2个已经排序的list
 *
 * @author lgq
 */
public class MergeTwoList {
    public Node merge(Node first, Node second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.value < second.value) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.setNext(new Node(2));
        first.setNext(new Node(3));

        Node second = new Node(4);
        second.setNext(new Node(5));
        second.setNext(new Node(6));

        MergeTwoList mergeTwoList = new MergeTwoList();
        Node merge = mergeTwoList.merge(first, second);
        merge.printAll();
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode [val=" + value + ", next=" + next + "]";
        }

        public Node getNextNode() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void printAll() {
            String str = "(value = " + value;
            while (next != null) {
                str += ", nextData = " + next.value;
                next = next.next;
            }
            str += ")";
            System.out.println(str);
        }
    }
}
