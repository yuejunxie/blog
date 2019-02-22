package com.drawinds.blog.rpc.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 0:49
 * Description:
 */
public class UserClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50001).usePlaintext().build();

            UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

            UserInfo userInfo = stub
                    .userDetails(UserParam.newBuilder().setCode("Baeldung").setPageNo(1).setPageSize(10).build());

            System.out.println(userInfo.getName());
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
