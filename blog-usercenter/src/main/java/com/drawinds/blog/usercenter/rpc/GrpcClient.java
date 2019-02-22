package com.drawinds.blog.usercenter.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloResponse;

import java.util.concurrent.TimeUnit;

import static examples.helloworld.HelloServiceGrpc.*;
import static examples.helloworld.HelloServiceGrpc.HelloServiceBlockingStub;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/12 21:18
 * Description:
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

            HelloServiceBlockingStub stub = newBlockingStub(channel);

            HelloResponse helloResponse = stub
                    .hello(HelloRequest.newBuilder().setFirstName("Baeldung").setLastName("gRPC").build());

            System.out.println(helloResponse.getGreeting());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
