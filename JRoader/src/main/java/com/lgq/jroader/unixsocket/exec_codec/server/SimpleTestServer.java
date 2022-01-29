package com.lgq.jroader.unixsocket.exec_codec.server;

import com.lgq.jroader.unixsocket.exec_codec.USConst;
import org.newsclub.net.unix.AFUNIXServerSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lgq
 */
public class SimpleTestServer {
    public static void main(String[] args) throws IOException {
        try (AFUNIXServerSocket server = AFUNIXServerSocket.newInstance()) {
            server.bind(new AFUNIXSocketAddress(USConst.File_File));
            System.out.println("server: " + server);

            while (!Thread.interrupted()) {
                System.out.println("Waiting for connection...");
                try (Socket sock = server.accept()) {
                    System.out.println("Connected: " + sock);

                    try (InputStream is = sock.getInputStream(); //
                         OutputStream os = sock.getOutputStream()) {
                        System.out.println("Saying hello to client " + os);

                        /*
                        os.write(0x01);
                        os.write(0x02);
                        os.write(0x01);
                        os.write(0x01);
                        os.write(0x00);*/

                        os.write("Hello, dear Client".getBytes());
                        os.flush();

                        byte[] buf = new byte[128];
                        int read = is.read(buf);
                        System.out.println("Client's response: " + new String(buf, 0, read));
                    }
                }
            }
        }
    }
}
