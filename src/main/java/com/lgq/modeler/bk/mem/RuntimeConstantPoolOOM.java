package com.lgq.modeler.bk.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2019/12/13.
 * 运行时-常量池-溢出
 * jdk7:-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk8:-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *
 * @author lgq
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
