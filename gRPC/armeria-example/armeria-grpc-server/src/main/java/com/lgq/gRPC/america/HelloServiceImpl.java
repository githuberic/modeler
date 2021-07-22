package com.lgq.gRPC.america;


import com.lgq.gRPC.armeria.HelloReply;
import com.lgq.gRPC.armeria.HelloRequest;
import com.lgq.gRPC.armeria.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 *
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    /**
     * Sends a {@link HelloReply} immediately when receiving a request.
     */
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(buildReply(toMessage(request.getName())));
        responseObserver.onCompleted();
    }

    static String toMessage(String name) {
        return "Hello, " + name + '!';
    }

    private static HelloReply buildReply(Object message) {
        return HelloReply.newBuilder().setMessage(String.valueOf(message)).build();
    }
}
