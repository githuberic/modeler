package com.lgq.gRPC.america;

import com.lgq.gRPC.armeria.HelloRequest;
import com.lgq.gRPC.armeria.HelloServiceGrpc;
import io.grpc.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class ArmeriaGrpcServer {
    private static final Logger logger = LoggerFactory.getLogger(ArmeriaGrpcServer.class);

    public static void main(String[] args) throws Exception {
        final Server server = newServer(8080, 8443);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
            logger.info("Server has been stopped.");
        }));

        server.start().join();
        final InetSocketAddress localAddress = server.activePort().localAddress();
        final boolean isLocalAddress = localAddress.getAddress().isAnyLocalAddress() ||
                localAddress.getAddress().isLoopbackAddress();
        logger.info("Server has been started. Serving DocService at http://{}:{}/docs",
                isLocalAddress ? "127.0.0.1" : localAddress.getHostString(), localAddress.getPort());
    }

    static Server newServer(int httpPort, int httpsPort) throws Exception {
        final HelloRequest exampleRequest = HelloRequest.newBuilder().setName("Armeria").build();
        final HttpServiceWithRoutes grpcService =
                GrpcService.builder()
                        .addService(new HelloServiceImpl())
                        // See https://github.com/grpc/grpc-java/blob/master/documentation/server-reflection-tutorial.md
                        .addService(ProtoReflectionService.newInstance())
                        .supportedSerializationFormats(GrpcSerializationFormats.values())
                        .enableUnframedRequests(true)
                        // You can set useBlockingTaskExecutor(true) in order to execute all gRPC
                        // methods in the blockingTaskExecutor thread pool.
                        // .useBlockingTaskExecutor(true)
                        .build();

        return Server.builder()
                .http(httpPort)
                .https(httpsPort)
                .tlsSelfSigned()
                .service(grpcService)
                // You can access the documentation service at http://127.0.0.1:8080/docs.
                // See https://line.github.io/armeria/server-docservice.html for more information.
                .serviceUnder("/docs", DocService.builder()
                        .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME,
                                "Hello", exampleRequest)
                        .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME,
                                "LazyHello", exampleRequest)
                        .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME,
                                "BlockingHello", exampleRequest)
                        .exclude(DocServiceFilter.ofServiceName(
                                ServerReflectionGrpc.SERVICE_NAME))
                        .build())
                .build();
    }

}
