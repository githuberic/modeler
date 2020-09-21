package com.lgq.modeler.ds.list;

/**
 * Created by eric on 2018/12/26.
 */
public class SLApp {
    private static String x;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SList<String> list = new SList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("输出第" + i + ":" + list.get(i));

        }
        System.out.println();
        System.out.println("测试删除");
        x = list.Delete(0);
        System.out.println("删除了" + x);
        for (int i = 0; i <= list.size(); i++) {
            System.out.println("输出第" + i + ":" + list.get(i));

        }
        System.out.println("测试修改");
        list.Renew("Yimi", 2);
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("输出第" + i + ":" + list.get(i));

        }
        System.out.println();
        System.out.println("测试查找");
        x = list.get(3);
        System.out.println("x=" + x);
    }
}
