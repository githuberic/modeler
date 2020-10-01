package com.lgq.modeler.ds.array.v1;

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
        this(10);
    }

    public int getCapacity() {
        return this.data.length;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

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

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = t;
        size++;
    }

    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return ret;
    }

    public void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        //  数组复制
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        System.out.println(">>>resize()");
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
            throw new IndexOutOfBoundsException("超过数组实际元素范围!");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed! Require index >=0 and index < size.");
        }
    }


    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<>(3);
        genericArray.add(3, 0);
        genericArray.add(22, 1);
        genericArray.add(9, 2);
        genericArray.add(8, 3);
        genericArray.add(5, 4);
        System.out.println(genericArray.toString());
        System.out.println(">>>remove");
        genericArray.remove(2);
        System.out.println(genericArray.toString());
        genericArray.add(44, 2);
        int findPosition = genericArray.find(44);
        System.out.println(String.format(">>>find,element=%s,position=%d\n", 44, findPosition));
    }
}
