package com.lgq.singleton.v3;

/**
 * Created by eric on 2019/12/29.
 *
 * @author lgq
 */
public class Singleton {
    private Singleton() {
    }

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        // 避免所有的thread串行化
        if (singleton == null) {
            // 避免创建多个instance
            synchronized (Singleton.class) {
                if (singleton == null) {
                    /*
                    并非原子操作，在jvm中包含了3步
                    * 1:给singleton分配内存空间
                    * 2:调用singleton构造函数来初始化singleton
                    * 3:将singleton对象指向分配的内存空间(执行完这步singleton!=null)
                    * 备注:在jvm内部存在重排序的优化,可能 1->3->2
                    */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
