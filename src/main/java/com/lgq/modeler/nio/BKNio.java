package com.lgq.modeler.nio;

import java.nio.ByteBuffer;

/**
 * Created by eric on 2018/10/22.
 */
public class BKNio {
    public static void main(String[] args) {
        bk2();
    }

    private static void bk1() {
        // 1.使用allocate()申请10个字节的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("------------allocate------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 2.使用put()存放5个字节到缓冲区
        byteBuffer.put("abcde".getBytes());
        System.out.println("------------put------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 3.切换到读取数据模式
        byteBuffer.flip();
        System.out.println("------------flip------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 4.从缓冲区中读取数据
        System.out.println("------------get------------------");
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 5.设置为可重复读取
        System.out.println("------------rewind------------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2, 0, bytes2.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 6。clear清空缓存区，但是内容没有被清掉，还存在。只不过这些数据状态为被遗忘状态。
        System.out.println("------------clear------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] bytes3 = new byte[10];
        byteBuffer.get(bytes3);
        System.out.println(new String(bytes3, 0, bytes3.length));
    }

    private static void bk2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abcde".getBytes());
        byteBuffer.flip();

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes, 0, 2);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.mark();
        System.out.println("---------mark----------");
        byteBuffer.get(bytes, 0, 2);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.reset();
        System.out.println("---------reset----------");

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}
