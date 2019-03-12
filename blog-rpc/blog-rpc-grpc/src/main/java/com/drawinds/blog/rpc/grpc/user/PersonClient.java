package com.drawinds.blog.rpc.grpc.user;

import com.drawinds.blog.rpc.grpc.Person;
import com.drawinds.blog.rpc.grpc.PersonServiceGrpc;
import com.drawinds.blog.rpc.grpc.PersonServiceGrpc.PersonServiceStub;
import com.drawinds.blog.rpc.grpc.Result;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;

import static com.drawinds.blog.rpc.grpc.PersonServiceGrpc.newBlockingStub;
import static com.drawinds.blog.rpc.grpc.PersonServiceGrpc.newStub;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 15:14
 * Description:
 */
@Slf4j
public class PersonClient {

    public static void main(String[] args) throws InterruptedException {
//        simpleHello();
//        serverStreamHello();
//        clientStreamHello();
        biStreamHello();
    }

    @Test
    public static void simpleHello() {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext().build();
        //定义同步阻塞的stub
        PersonServiceGrpc.PersonServiceBlockingStub blockingStub = newBlockingStub(channel);

        Person person = Person.newBuilder().setMyName("World").build();
        //simple
        log.info("---simple rpc---");
        log.info(blockingStub.simpleHello(person).getString());
        channel.shutdown();
    }

    @Test
    public static void serverStreamHello() {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext().build();
        //定义同步阻塞的stub
        PersonServiceGrpc.PersonServiceBlockingStub blockingStub = newBlockingStub(channel);

        Person person = Person.newBuilder().setMyName("World").build();

        //server side
        log.info("---server stream rpc---");
        //返回结果是Iterator
        Iterator<Result> it = blockingStub.serverStreamHello(person);
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        channel.shutdown();
    }

    @Test
    public static void clientStreamHello() throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext().build();
        //定义异步的stub
        PersonServiceStub asyncStub = newStub(channel);
        Person person = Person.newBuilder().setMyName("World").build();

        //client side
        log.info("---client stream rpc---");
        StreamObserver<Result> responseObserver = new StreamObserver<Result>() {
            @Override
            public void onNext(Result result) {
                log.info("client stream--" + result.getString());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                //关闭channel
//                channel.shutdown();
            }
        };
        StreamObserver<Person> clientStreamObserver = asyncStub.clientStreamHello(responseObserver);
        clientStreamObserver.onNext(Person.newBuilder().setMyName("World").build());
        clientStreamObserver.onNext(Person.newBuilder().setMyName("World2").build());
        clientStreamObserver.onCompleted();
        //由于是异步获得结果，所以sleep一秒
        Thread.sleep(1000);
    }

    @Test
    public static void biStreamHello() throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext().build();
        //定义异步的stub
        PersonServiceStub asyncStub = newStub(channel);

        Person person = Person.newBuilder().setMyName("World").build();

        //bi stream
        log.info("---bidirectional stream rpc---");
        StreamObserver<Result> responseObserver = new StreamObserver<Result>() {
            @Override
            public void onNext(Result result) {
                log.info("bidirectional stream--" + result.getString());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                channel.shutdown();
            }
        };
        StreamObserver<Person> biStreamObserver = asyncStub.biStreamHello(responseObserver);
        biStreamObserver.onNext(Person.newBuilder().setMyName("World").build());
        biStreamObserver.onNext(Person.newBuilder().setMyName("World2").build());
        biStreamObserver.onCompleted();
        //由于是异步获得结果，所以sleep一秒
        Thread.sleep(1000);
    }
}
