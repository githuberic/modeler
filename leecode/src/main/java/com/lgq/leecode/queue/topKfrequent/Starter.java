package com.lgq.leecode.queue.topKfrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Starter {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 4, 4, 5};
        int k = 3;

        int[] arrTop = topKFrequentV2(nums, k);
        for (int val : arrTop) {
            System.out.println(val);
        }
    }

    /**
     * 先定义结果数组 res，以及存放数组 nums 中的元素以及对应出现次数的 hashMap；
     * 遍历数组 nums，以数组 nums 中的元素以及对应出现次数作为键值对存放到 hashMap 中；
     * 定义优先级队列 queue，存储的元素类型为长度为 2 的数组（int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数），并将其排序规则设置为按照元素出现次数进行升序排序；
     * 遍历 hashMap ，对于当前的 entry<key, value>，进行如下判断：
     * 如果队列长度为 k，并且 queue.peek()[1] < value，则将其从队首移出，并将 int[]{key, value} 添加到队列尾部；
     * 如果队列长度小于 k，则将 int[]{key, value} 添加到队列尾部；
     * 将队列中的结果保存到 res 中，最后返回 res 即可。
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] topKFrequent(int[] nums, int k) {
        int[] arrRes = new int[k];

        //hashMap 存放数组 nums 中的元素以及对应出现次数
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        /*
            (1) int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            (2) 自定义排序规则: 按照元素出现次数进行升序排序
        */
        PriorityQueue<int[]> queue;
        queue = new PriorityQueue<>(Comparator.comparingInt(a -> {
            return a[1];
        }));
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();

            if (queue.size() == k) {
                if (queue.peek()[1] < cnt) {
                    //取出队首元素
                    queue.poll();
                    queue.offer(new int[]{num, cnt});
                }
            } else {
                // 向队列尾部添加元素
                queue.offer(new int[]{num, cnt});
            }
        }

        for (int i = 0; i < k; i++) {
            arrRes[i] = queue.poll()[0];
        }
        return arrRes;
    }

    private static int[] topKFrequentV2(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{key, val});
            } else {
                if (priorityQueue.peek()[1] < val) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, val});
                }
            }
        }

        int[] arrRes = new int[k];
        for (int i = 0; i < k; i++) {
            arrRes[i] = priorityQueue.poll()[0];
        }
        return arrRes;
    }
}
