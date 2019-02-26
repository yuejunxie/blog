package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Role;
import com.drawinds.blog.rpc.grpc.UserParam;
import com.drawinds.blog.rpc.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 0:49
 * Description:
 */
@Slf4j
public class UserClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50001).usePlaintext().build();

            UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

            Role userInfo = stub
                    .userRole(UserParam.newBuilder().setCode("Baeldung").setPageNo(1).setPageSize(10).build());

            log.info(userInfo.getName());
        } catch (Exception e) {
            log.error("Exception:",e);
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
