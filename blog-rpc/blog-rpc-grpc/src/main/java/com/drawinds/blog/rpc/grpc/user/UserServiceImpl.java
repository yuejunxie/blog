package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Role;
import com.drawinds.blog.rpc.grpc.UserInfo;
import com.drawinds.blog.rpc.grpc.UserParam;
import com.drawinds.blog.rpc.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 0:32
 * Description:
 */
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
}
