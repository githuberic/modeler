package com.lgq.jbasic.obj.jolcore;

import com.carrotsearch.sizeof.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

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

        System.out.println(RamUsageEstimator.sizeOf(value));

        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(value).toPrintable());
        //获取对象总大小
        System.out.println(GraphLayout.parseInstance(value).totalSize());
        //查看对象外部信息
        System.out.println(GraphLayout.parseInstance(value).toPrintable());
    }
}
