package com.lgq.modeler.nio.v1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by eric on 2019/12/26.
 *
 * @author lgq
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 连接到服务端
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        sc.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hi, From Client".getBytes());
        buffer.flip();

        sc.write(buffer);
        buffer.clear();
        sc.close();
    }
}
