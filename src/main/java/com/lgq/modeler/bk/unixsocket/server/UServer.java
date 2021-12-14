package com.lgq.modeler.bk.unixsocket.server;

import com.lgq.modeler.bk.unixsocket.Const;
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
public class UServer {
    public static void main(String[] args) throws Exception {
        // 建立 Unix Socket 连接
        File sockFile = new File(Const.SOCKET_FILE);

        UnixSocketAddress address = new UnixSocketAddress(sockFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        UnixSocket unixSocket = new UnixSocket(channel);
        //writer = new PrintWriter(Channels.newOutputStream(channel));

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
