package com.lgq.jbasic.obj;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author lgq
 */
public class ObjSizeExec {
    public static void main(String[] args) throws IOException {
        Integer value = 100;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oss = new ObjectOutputStream(bos);
        oss.writeObject(value);
        System.out.println(bos.size());
    }
}
