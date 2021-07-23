package com.lgq.grpc.hello.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class HelloWorldServer {
    private Server server;

    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // jvm关闭前执行
            System.err.println("*** shutting down gRPC server since JVM is shutting down");

            try {
                HelloWorldServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            System.err.println("*** server shut down");
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * 阻塞等待主线程终止
     *
     * @throws InterruptedException
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }
}
