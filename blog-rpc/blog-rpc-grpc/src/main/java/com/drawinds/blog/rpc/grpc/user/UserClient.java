package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Role;
import com.drawinds.blog.rpc.grpc.UserInfo;
import com.drawinds.blog.rpc.grpc.UserParam;
import com.drawinds.blog.rpc.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50001).usePlaintext().build();
//        simple(channel);
//        serverStream(channel);
        clientStream(channel);
//        biStream(channel);

    }

    private static void biStream(ManagedChannel channel) {
        UserServiceGrpc.UserServiceStub stub = UserServiceGrpc.newStub(channel);
        UserParam userParam = UserParam.newBuilder().setPageNo(1).setPageSize(10).setCode("xx").build();
        StreamObserver<UserInfo> responseObserver = new StreamObserver<UserInfo>() {
            @Override
            public void onNext(UserInfo value) {
                log.info(value.toString());
            }

            @Override
            public void onError(Throwable t) {
                log.error("", t);
            }

            @Override
            public void onCompleted() {
                channel.shutdown();
            }
        };

        StreamObserver<UserParam> clientStreamObserver = stub.biStreamUserDerails(responseObserver);
        clientStreamObserver.onNext(userParam);
        clientStreamObserver.onNext(userParam);
        clientStreamObserver.onCompleted();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clientStream(ManagedChannel channel) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);

            StreamObserver<UserInfo> streamObserver = new StreamObserver<UserInfo>() {

                @Override
                public void onNext(UserInfo value) {
                    log.info("client stream" + value.getName());
                }

                @Override
                public void onError(Throwable t) {
                    log.info("", t);
                    countDownLatch.countDown();
                }

                @Override
                public void onCompleted() {
                    log.info("on completed");
//                    channel.shutdown();
                    countDownLatch.countDown();
                }
            };

            UserServiceGrpc.UserServiceStub stub = UserServiceGrpc.newStub(channel);

            StreamObserver<UserParam> clientStreamObserver = stub.clientStreamUserDerails(streamObserver);

            for (int i = 0; i < 2; i++) {
                UserParam userParam = UserParam.newBuilder().setCode("Baeldung").setPageNo(i).setPageSize(10).build();
                clientStreamObserver.onNext(userParam);
//                if (countDownLatch.getCount() == 0) {
//                    return;
//                }
            }
            clientStreamObserver.onCompleted();

            if (!countDownLatch.await(15, TimeUnit.SECONDS)) {
                log.info("not completed");
            }
        } catch (Exception e) {
            log.error("Exception:", e);
        } finally {
            if (channel != null) {
                try {
                    channel.shutdown().awaitTermination(15, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void serverStream(ManagedChannel channel) {
        try {
            UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

            Iterator<UserInfo> iterator = stub.serverStreamUserDerails(UserParam.newBuilder().setCode("Baeldung").setPageNo(1).setPageSize(10).build());
            while (iterator.hasNext()) {
                log.info(iterator.next().getName());
            }
        } catch (Exception e) {
            log.error("Exception:", e);
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

    private static void simple(ManagedChannel channel) {
        try {
            UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

            Role userInfo = stub.userRole(UserParam.newBuilder().setCode("Baeldung").setPageNo(1).setPageSize(10).build());

            log.info(userInfo.getName());
        } catch (Exception e) {
            log.error("Exception:", e);
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
