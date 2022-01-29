package com.lgq.jroader.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2019/12/13.
 * Java堆溢出测试
 * -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpOnOutOfMemoryError dump出当前的内存堆转存储快照以便事后分析;
 * OutOfMemoryError:Java heap space
 *
 * @author lgq
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
