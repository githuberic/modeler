package com.lgq.grpc.hello.server;

import com.lgq.grpc.hello.GreeterGrpc;
import com.lgq.grpc.hello.HelloReply;
import com.lgq.grpc.hello.HelloRequest;
import io.grpc.stub.StreamObserver;

/**
 * @author lgq
 */
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request,
                         StreamObserver<HelloReply> responseObserver) {
        HelloReply helloResponse = HelloReply
                .newBuilder()
                .setMessage("Hello " + request.getName() + ", I'm Java grpc Server")
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
