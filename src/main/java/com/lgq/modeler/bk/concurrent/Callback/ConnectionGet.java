package com.lgq.modeler.bk.concurrent.Callback;

import java.util.HashMap;

/**
 * Created by eric on 2018/12/4.
 */
public class ConnectionGet {
    public void execute(final ICallback<HashMap<String, String>> callback) {
        new Thread(
                () -> {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("key", "value");
                    callback.callback(hashMap);
                }
        ).start();
    }

    public static void main(String[] args) {
        ConnectionGet connectionGet = new ConnectionGet();
        connectionGet.execute(new ICallback<HashMap<String, String>>() {
            @Override
            public void callback(HashMap<String, String> stringStringHashMap) {
                if (stringStringHashMap != null && !stringStringHashMap.isEmpty()) {
                    System.out.println(">>>get,key" + stringStringHashMap.get("key"));
                }
            }
        });
        System.out.println(">>>Main thread done...");
    }
}
