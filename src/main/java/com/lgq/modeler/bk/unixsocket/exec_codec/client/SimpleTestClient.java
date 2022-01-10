package com.lgq.modeler.bk.unixsocket.exec_codec.client;

import com.lgq.modeler.bk.unixsocket.exec_0.Const;
import com.lgq.modeler.bk.unixsocket.exec_codec.USConst;
import org.newsclub.net.unix.AFUNIXSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;
import org.newsclub.net.unix.AFUNIXSocketException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lgq
 */
public class SimpleTestClient {

    public static void main(String[] args) throws IOException {
        try (AFUNIXSocket sock = AFUNIXSocket.newInstance()) {
            try {
                sock.connect(new AFUNIXSocketAddress(USConst.File_File));
            } catch (AFUNIXSocketException e) {
                System.out.println("Cannot connect to server. Have you started it?");
                System.out.flush();
                throw e;
            }
            System.out.println("Connected");

            try (InputStream is = sock.getInputStream(); //
                 OutputStream os = sock.getOutputStream()) {

                byte[] buf = new byte[128];

                int read = is.read(buf);
                System.out.println("Server says: " + new String(buf, 0, read));

                System.out.println("Replying to server...");
                os.write("Hi Server".getBytes());
                os.flush();
            }
        }

        System.out.println("End of communication.");
    }
}