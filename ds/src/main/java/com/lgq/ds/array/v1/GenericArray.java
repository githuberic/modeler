package com.lgq.ds.array.v1;

/**
 * Created by eric on 2019/12/31.
 *
 * @author lgq
 */
public class GenericArray<T> {

    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 默认10个元素
     */
    public GenericArray() {
        this(16);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标, 未找到，返回 -1
     *
     * @param t
     * @return
     */
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void add(T t, int index) {
        checkIndex(index);

        // 如果实际元素达到数组容量上限，则对数组进行扩容
        if (size >= data.length) {
            resize(data.length * 2);
        }

        // Move back(后移)
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = t;
        size++;
    }

    public T remove(int index) {
        checkIndexForRemove(index);

        T ret = data[index];

        // Move forward 迁移
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T t) {
        int index = find(t);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    public void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        //  数组复制
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity = %d\n", this.size, this.data.length));
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(data[i]);
            if (i != this.size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Out of range of actual array");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed! Require index >=0 and index < size.");
        }
    }
}
