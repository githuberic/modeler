package com.lgq.modeler.bk.pipedio;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by eric on 2018/8/15.
 */
public class Reader implements Runnable {
    private PipedInputStream in;

    Reader(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            System.out.println("读取前。。没有数据，心塞");
            int len = in.read(buf);
            System.out.println("读到数据。。不心塞");
            String s = new String(buf, 0, len);
            System.out.println(s);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("管道读取流失败");
        }
    }
}
