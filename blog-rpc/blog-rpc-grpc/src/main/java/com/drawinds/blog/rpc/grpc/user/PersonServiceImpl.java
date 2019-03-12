package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Person;
import com.drawinds.blog.rpc.grpc.PersonServiceGrpc.PersonServiceImplBase;
import com.drawinds.blog.rpc.grpc.Result;
import io.grpc.stub.StreamObserver;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 15:11
 * Description:
 */
public class PersonServiceImpl extends PersonServiceImplBase {

    @Override
    public void simpleHello(Person request, StreamObserver<Result> responseObserver) {
        responseObserver.onNext(Result.newBuilder().setString("hello, " + request.getMyName()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void serverStreamHello(Person request, StreamObserver<Result> responseObserver) {
        //返回多个结果
        responseObserver.onNext(Result.newBuilder().setString("hello, " + request.getMyName()).build());
        responseObserver.onNext(Result.newBuilder().setString("hello2, " + request.getMyName()).build());
        responseObserver.onNext(Result.newBuilder().setString("hello3, " + request.getMyName()).build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Person> clientStreamHello(StreamObserver<Result> responseObserver) {
        return new StreamObserver<Person>() {
            private Result.Builder builder = Result.newBuilder();

            @Override
            public void onNext(Person value) {
                builder.setString(builder.getString() + "," + value.getMyName());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                builder.setString("hello" + builder.getString());
                responseObserver.onNext(builder.build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Person> biStreamHello(StreamObserver<Result> responseObserver) {
        return new StreamObserver<Person>() {
            private Result.Builder builder = Result.newBuilder();

            @Override
            public void onNext(Person value) {
                responseObserver.onNext(Result.newBuilder().setString("hello2, " + value.getMyName()).build());
                responseObserver.onNext(Result.newBuilder().setString("hello3, " + value.getMyName()).build());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
