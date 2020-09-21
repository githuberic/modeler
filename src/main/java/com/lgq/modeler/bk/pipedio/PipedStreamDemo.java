package com.lgq.modeler.bk.pipedio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by eric on 2018/8/15.
 */
public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        in.connect(out);

        Reader r = new Reader(in);
        Writer w = new Writer(out);
        new Thread(r).start();
        new Thread(w).start();
    }
}
