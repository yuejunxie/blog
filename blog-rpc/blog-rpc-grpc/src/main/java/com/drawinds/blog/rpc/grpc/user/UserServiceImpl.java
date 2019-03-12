package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Role;
import com.drawinds.blog.rpc.grpc.UserInfo;
import com.drawinds.blog.rpc.grpc.UserParam;
import com.drawinds.blog.rpc.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 0:32
 * Description:
 */
@Slf4j
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void userDetails(UserParam request, StreamObserver<UserInfo> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getCode())
                .append(" ")
                .append(request.getPageNo())
                .append(request.getPageSize())
                .toString();
        UserInfo userInfo = UserInfo.newBuilder().setName(greeting).build();
        responseObserver.onNext(userInfo);
        responseObserver.onCompleted();
    }

    @Override
    public void userRole(UserParam request, StreamObserver<Role> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getCode())
                .append(" ")
                .append(request.getPageNo())
                .append(request.getPageSize())
                .toString();
        Role role = Role.newBuilder().setName("role" + greeting).build();
        responseObserver.onNext(role);
        responseObserver.onCompleted();
    }

    @Override
    public void serverStreamUserDerails(UserParam request, StreamObserver<UserInfo> responseObserver) {
        responseObserver.onNext(UserInfo.newBuilder().setName("hello, ").build());
        responseObserver.onNext(UserInfo.newBuilder().setName("hello2, ").build());
        responseObserver.onNext(UserInfo.newBuilder().setName("hello3, ").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<UserParam> clientStreamUserDerails(StreamObserver<UserInfo> responseObserver) {
        return new StreamObserver<UserParam>() {
            private int sum = 0;
            private int cnt = 0;
            private double avg;

            @Override
            public void onNext(UserParam value) {
                log.info(value.getPageNo() + value.getPageSize() + value.getCode());
                cnt++;
            }

            @Override
            public void onError(Throwable t) {
                log.error("", t);
            }

            @Override
            public void onCompleted() {
                UserInfo.Builder builder = UserInfo.newBuilder();
                builder.setName("Hello client stream" + cnt);
                responseObserver.onNext(builder.build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<UserParam> biStreamUserDerails(StreamObserver<UserInfo> responseObserver) {
        return new StreamObserver<UserParam>() {
            private UserInfo.Builder builder = UserInfo.newBuilder();

            @Override
            public void onNext(UserParam value) {
                builder.setName("client stream" + value.getPageNo() + value.getPageSize());
                builder.setName("Hello" + builder.getName());
                responseObserver.onNext(builder.build());
                builder.setName("Hello" + builder.getName());
                responseObserver.onNext(builder.build());
            }

            @Override
            public void onError(Throwable t) {
                log.error("", t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
