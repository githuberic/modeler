package com.lgq.modeler.bk.serialize.v1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by eric on 2019/12/27.
 *
 * @author lgq
 */
public class SerializeV1 implements Serializable {
    private static final long serialVersionUID = 6978013871557066854L;

    public int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("./serialize.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            SerializeV1 serializeV1 = new SerializeV1();
            oos.writeObject(serializeV1);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
