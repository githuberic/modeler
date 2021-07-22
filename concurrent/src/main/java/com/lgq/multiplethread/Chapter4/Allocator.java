package com.lgq.multiplethread.Chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2019/12/16.
 *
 * @author lgq
 */
public class Allocator {
    private List<Object> als = new ArrayList<>();

    // 一次性申请所有资源
    public synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    // 归还资源
    public synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }
}
