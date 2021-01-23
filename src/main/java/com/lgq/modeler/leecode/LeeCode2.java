package com.lgq.modeler.leecode;

/**
 * @author lgq
 */
public class LeeCode2 {
    ListNode head = null;

    public LeeCode2() {
        this.head = new ListNode(0);
    }

    static class ListNode {
        Integer value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            // 创建新节点
            carry = sum / 10;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        ListNode tailNode = null;
        ListNode startNode = this.head;
        while (startNode.next != null) {
            startNode = startNode.next;
        }
        tailNode = startNode;
        tailNode.next = newNode;
    }

    public static void main(String[] args) {
        LeeCode2 leeCode2 = new LeeCode2();
        leeCode2.add(2);
        leeCode2.add(3);
        leeCode2.add(4);

        LeeCode2 leeCode22 = new LeeCode2();
        leeCode22.add(5);
        leeCode22.add(6);
        leeCode22.add(4);

        ListNode listNodeSum = leeCode2.addTwoNumber(leeCode2.head.next, leeCode22.head.next);


        ListNode p = listNodeSum;
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.value);
            } else {
                System.out.print(p.value + "-->");
            }
            p = p.next;
        }
        System.out.println();
    }
}
