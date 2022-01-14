package com.lgq.modeler.bk.unixsocket.starter;

import jnr.unixsocket.UnixSocket;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author lgq
 */
public class DemoUS {
    final static String PATH = "/Users/guoqingliu/rainbow-agent/rainbow.sock";//"/var/run/docker.sock"
    public static void main(String[] args) throws Exception {
        // 建立 Unix Socket 连接
        File sockFile = new File(PATH);

        UnixSocketAddress address = new UnixSocketAddress(sockFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        UnixSocket unixSocket = new UnixSocket(channel);

        // 调用 Docker API
        PrintWriter w = new PrintWriter(unixSocket.getOutputStream());
        w.println("GET /v1.41/containers/json HTTP/1.1");
        w.println("Host: http");
        w.println("Accept: */*");
        w.println("");
        w.flush();

        // 关闭 Output，否则会导致下面的 read 操作一直阻塞
        unixSocket.shutdownOutput();

        // 获取返回结果
        System.out.println("---- Docker Response ----");
        BufferedReader br = new BufferedReader(new InputStreamReader(unixSocket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        unixSocket.close();
    }
}
