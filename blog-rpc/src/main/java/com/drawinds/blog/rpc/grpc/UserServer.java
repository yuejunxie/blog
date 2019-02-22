package com.drawinds.blog.rpc.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 0:28
 * Description:
 */
public class UserServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        final Server server = ServerBuilder.forPort(50001)
                .addService(new UserServiceImpl()).build().start();
        server.awaitTermination();
    }
}
