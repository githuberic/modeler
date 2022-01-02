package com.lgq.modeler.bk.unixsocket.client;

import com.lgq.modeler.bk.unixsocket.Const;
import jnr.unixsocket.UnixSocket;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @@author lgq
 */
public class USclient {
    public static void main(String[] args) throws Exception {

        // 建立 Unix Socket 连接
        File sockFile = new File(Const.SOCKET_FILE);

        UnixSocketAddress address = new UnixSocketAddress(sockFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        UnixSocket unixSocket = new UnixSocket(channel);
        //writer = new PrintWriter(Channels.newOutputStream(channel));

        PrintWriter writer = new PrintWriter(unixSocket.getOutputStream());
        String str = "lgq-杭州";
        byte[] bContent = str.getBytes("UTF-8");
        writer.write(String.valueOf(bContent), 0, bContent.length);
        writer.flush();
        unixSocket.close();
    }
}
