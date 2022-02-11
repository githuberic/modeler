package com.lgq.jbasic.unixsocket.exec_01.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.lgq.jbasic.unixsocket.exec_01.Const;
import org.newsclub.net.unix.AFUNIXServerSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;

/**
 * @author lgq
 */
public class SimpleTestServer {
    public static void main(String[] args) throws IOException {
        //final File socketFile = new File(new File(System.getProperty("java.io.tmpdir")), "junixsocket-test.sock");
        File socketFile = new File(Const.SOCKET_FILE);
        try (AFUNIXServerSocket server = AFUNIXServerSocket.newInstance()) {
            server.bind(new AFUNIXSocketAddress(socketFile));
            //System.out.println("server: " + server);

            while (!Thread.interrupted()) {
                //System.out.println("Waiting for connection...");
                try (Socket sock = server.accept()) {
                    //System.out.println("Connected: " + sock);

                    try (InputStream is = sock.getInputStream(); //
                         OutputStream os = sock.getOutputStream()) {
                        System.out.println("Saying hello to client " + os);
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
