package com.lgq.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.Sentiment;

/**
 * @author lgq
 */
public class MyGrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.greeting(
                HelloRequest.newBuilder()
                        .setName("lgq")
                        .setAge(18)
                        .setSentiment(Sentiment.HAPPY)
                        .build());

        System.out.println(helloResponse);

        channel.shutdown();
    }
}
