package com.lgq.modeler.bk.pipedio;

import java.io.PipedOutputStream;

/**
 * Created by eric on 2018/8/15.
 */
public class Writer implements Runnable {
    private PipedOutputStream out;

    Writer(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始写入数据，等待6秒");
            Thread.sleep(6000);
            out.write("piped comming".getBytes());
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("管道输出流失败");
        }
    }
}
