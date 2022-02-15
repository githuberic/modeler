package com.lgq.ds.extension.topk.p2;

/**
 * @author lgq
 */
public class TopK {
    int[] items;
    int currentSize = 0;

    // 初始化为size + 1，从下标1开始保存元素。
    public TopK(int size) {
        items = new int[size + 1];
    }


    // 插入元素
    public void insert(int x) {
        if (currentSize == items.length - 1) {
            if (compare(x, items[1]) < 0) {
                return;
            } else if (compare(x, items[1]) > 0) {
                deleteMin();
            }
        }

        int hole = ++currentSize;
        for (items[0] = x; compare(x, items[hole / 2]) < 0; hole /= 2) {
            items[hole] = items[hole / 2];
        }
        items[hole] = x;
    }

    // 删除最小堆中最小元素
    public int deleteMin() {
        int min = items[1];
        items[1] = items[currentSize--];
        percolateDown(1);
        return min;
    }

    // 下滤
    public void percolateDown(int hole) {
        int child;
        int temp = items[1];

        for (; hole * 2 <= currentSize; hole = child) {
            child = 2 * hole;
            if (child != currentSize && compare(items[child + 1], items[child]) == -1) {
                child++;
            }
            if (compare(items[child], temp) < 0) {
                items[hole] = items[child];
            } else {
                break;
            }
        }
        items[hole] = temp;
    }

    // 制定比较规则
    public static int compare(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        TopK topK = new TopK(10);
        for (int i = 1; i <= 100; i++) {
            topK.insert(i);
        }
        for (int j = 1; j <= topK.currentSize; j++) {
            System.out.print(topK.items[j] + " ");
        }
        System.out.println();
    }
}
