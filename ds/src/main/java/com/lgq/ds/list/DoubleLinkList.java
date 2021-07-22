package com.lgq.ds.list;

/**
 * @param <T>
 * @author lgq
 */
public class DoubleLinkList<T> {

    private int size = 0;
    private Node<T> head;

    public DoubleLinkList() {
        head = new Node<>(null, null, null);
        head.pre = head;
        head.next = head;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node<T> getNode(int index) {
        checkIndex(index);

        /**
         * 当索引的值小于该链表长度的一半时，那么从链表的头结点开始向后找是最快的
         */
        if (index < size / 2) {
            Node<T> cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        }
        // 当索引值位于链表的后半段时，则从链表的另端开始找是最快的
        Node<T> cur = head.pre;
        int newIndex = size - (index + 1);
        for (int i = 0; i < newIndex; i++) {
            cur = cur.pre;
        }
        return cur;
    }

    public T getValue(Node<T> node) {
        return node.value;
    }

    public T getFirst() {
        return getValue(getNode(0));
    }

    public T getLast() {
        return getValue(getNode(size - 1));
    }

    public void insert(T value, int index) {
        if (size == 0) {
            head.value = value;
            head.pre = head;
            head.next = head;
            size++;
            return;
        }

        // 插入到首位
        if (index == 0) {
            Node<T> cur = new Node<T>(value, head, head.next);
            head.next.pre = cur;
            head.next = cur;
            size++;
            return;
        }

        // 先根据给出的插入位置 找到该链表原来在此位置的节点
        Node<T> node = getNode(index);

        // 放置的位置的前一个节点就是原节点的前置节点 而后节点就是原节点
        Node cur = new Node(value, node.pre, node);

        /**
         * 现将该位置也就是 原节点的前节点的后节点 赋值成为新节点
         * 然后将新节点的后置节点的值赋值成为原节点
         */
        node.pre.next = cur;
        node.pre = cur;
        size++;
    }

    public void insertInto(T value) {
        insert(value, 0);
    }

    /**
     * 将元素插入到链表的尾部
     *
     * @param value
     */
    public void insertToTail(T value) {
        // head.prev代表原来的尾部节点
        Node<T> tail = head.pre;
        // 新构造的节点
        Node<T> cur = new Node<>(value, tail, head);
        // 遵循两个原则 一 新插入节点的前一个节点的后一个节点为新节点。新节点的后一个节点的前一个节点是新节点
        head.pre.next = cur;
        head.pre = cur;
        size++;
    }

    public void delete(int index) {
        checkIndex(index);
        Node<T> node = getNode(index);
        // 记住此时的指针还没断开 赋值以后才相当于断开
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        node = null;
    }

    public void delFirst() {
        delete(0);
    }

    public void delLast() {
        delete(size - 1);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return;
    }

    private class Node<T> {
        private T value;
        private Node<T> pre;
        private Node<T> next;

        public Node(T value, Node<T> pre, Node<T> next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.insertInto("a1");
        doubleLinkList.insertInto("a2");
        doubleLinkList.insertInto("a3");
        doubleLinkList.insertInto("a4");
        doubleLinkList.insertInto("a5");
        doubleLinkList.insert("a6",1);
        DoubleLinkList.Node node = doubleLinkList.getNode(1);
        if (node != null) {
            System.out.println(node.value);
        }

    }
    // from https://www.cnblogs.com/ChenD/p/7814906.html
}
