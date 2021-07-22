package com.lgq.modeler.gRPC;

import com.lgq.gRPC.GreeterGrpc;
import com.lgq.gRPC.HelloReply;
import com.lgq.gRPC.HelloRequest;
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
