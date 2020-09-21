package com.lgq.modeler.ds.list;

/**
 * Created by eric on 2018/12/26.
 */
public class SList<T> {
    /**
     * 声明头节点
     */
    private Node<T> head;
    /**
     * 声明尾节点
     */
    private Node<T> last;
    /**
     * 链表的大小
     */
    private int size;

    public SList() {
        // 实例化头节点
        head = new Node<T>();
        last = head;
    }

    /**
     * 获取单链表中存储的元素总数
     *
     * @return 返回size属性
     */
    public int size() {
        return size;
    }

    /**
     * 获取指定索引位置的节点对象
     *
     * @param index
     * @return 返回获取到的节点对象
     */
    private Node<T> Select(int index) {
        // 将头节点的下一个节点赋给node
        Node<T> node = head.getNext();
        for (int i = 0; i < index; i++) {
            // 获取node的下一个节点
            node = node.getNext();
        }
        return node;
    }

    /**
     * 找到指定节点的数据域，并返回
     *
     * @param index 索引
     * @return 节点的数据域
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        // 查找指定索引位置的节点对象
        Node<T> node = Select(index);
        // 获取节点中的数据域元素并返回
        return node.getData();
    }

    /**
     * 增
     *
     * @param e e要添加的元素
     */
    public void add(T e) {
        // 以e实例化一个节点
        Node<T> node = new Node<T>(e);
        // 往尾节点后加节点
        last.setNext(node);
        // 该节点设为最后一个节点
        last = node;
        size++;
    }

    /**
     * 删除指定的节点e,并返回e
     *
     * @param index 为索引号
     * @return 返回删除的元素e
     */
    public T Delete(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        // 当索引为1时，令头节点的下一个节点为头节点
        if (index == 0) {
            Node<T> headNext = head.getNext();
            head.setNext(headNext.getNext());
            size--;
            return headNext.getData();
        }

        // 获取要删除节点的前一个节点
        Node<T> bNode = Select(index - 1);
        // 获取要删除的节点
        Node<T> Node = bNode.getNext();
        // 获取要删除节点的后一个节点
        Node<T> nNode = Node.getNext();

        // 先建立删除节点的前一个节点和删除节点的后一个节点的关系
        bNode.setNext(nNode);
        // 清除dNode的下一个节点
        Node.setNext(null);
        // 计数器减1
        size--;
        // 返回删除节点中的数据域
        return Node.getData();
    }

    /**
     * 修改指点位置的数据域
     *
     * @param x     新内容
     * @param index 索引位置
     * @return 返回修改后的数据
     */
    public T Renew(T x, int index) {
        if (index < 0 || index > size || size == 0) {
            return null;
        }
        // 获取一个新节点
        Node<T> xnode = new Node<T>(x);
        Node<T> node = Select(index);
        node.setData(xnode.getData());
        return node.getData();
    }
    //https://zhuanlan.zhihu.com/p/30141170
}
