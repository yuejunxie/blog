package com.drawinds.blog.advetisement.io;

import io.netty.buffer.UnpooledDirectByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 21:48
 * Description:
 */
@Slf4j
public class Server {

    private static final String MSG = "hello, I must be going \n";

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(7888));
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.wrap(MSG.getBytes());
        Selector selector = Selector.open();
        ByteBuffer read = ByteBuffer.allocateDirect(1024);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        while (true) {
            int select = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel socketChannel = serverChannel.accept();
                read.rewind();
                socketChannel.read(read);
                System.out.println(read);
                socketChannel.write(buffer);
                iterator.remove();
            }
            System.out.println(atomicInteger.incrementAndGet());
//            System.out.println("Waiting for connection....");
//            SocketChannel socketChannel = serverSocketChannel.accept();
//            if (socketChannel == null) {
//                Thread.sleep(10000);
//            } else {
//                System.out.println("Get connection from" + socketChannel.getRemoteAddress());
//                buffer.rewind();
//                socketChannel.write(buffer);
//                socketChannel.close();
//            }
        }

    }
}
