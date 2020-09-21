package com.lgq.modeler.bk.concurrent.Callback;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by eric on 2018/12/4.
 */
public class NettyTest {
    static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void doStm(final ICallback<Map<String, Object>> callback) {
        // 初始化一个线程
        Thread thread = new Thread(() -> {
            // 这里是业务逻辑处理
            System.out.println(">>>Doing biz...");
            // 为了能看出效果 ，让当前线程阻塞5秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 处理完业务逻辑，
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("key", "value");
            callback.callback(params);
        });
        es.execute(thread);
    }

    public static void main(String[] args) {
        doStm(new ICallback<Map<String, Object>>() {
            @Override
            public void callback(Map<String, Object> map) {
                System.out.println(">>>Sub thread done，back param key=" + map.get("key"));
            }
        });

        System.out.println(">>>Main thread done...");
    }
}
