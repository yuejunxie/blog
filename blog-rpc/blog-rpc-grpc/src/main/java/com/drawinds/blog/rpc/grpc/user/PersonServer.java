package com.drawinds.blog.rpc.grpc.user;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 15:20
 * Description:
 */
public class PersonServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new PersonServiceImpl()).build().start();
        server.awaitTermination();
    }
}
