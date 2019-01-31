package com.drawinds.blog.advertisement.service;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 20:50
 * Description:
 */
@Slf4j
@Component
public class MQConsumer {

    @Autowired
    private AdvertisementService advertisementService;

    Connection connection = null;
    Channel channel = null;

    @PostConstruct
    public void init() throws IOException, TimeoutException {
        //连接mq
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();//创建连接
        channel = connection.createChannel();//打开通道，发送消息
        //开始消费，从队列中读取消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                try {
                    advertisementService.newAdvertisement(message, message);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (SQLException e) {
                    //第三个参数是重发，他的作用是否启用取决于第二个参数
                    //通知mq,消息处理异常，不需要继续处理，丢弃
                    channel.basicNack(envelope.getDeliveryTag(), false, false);
                } catch (Exception e) {
                    log.error("出现不可知的异常，需要通知重发", e);
                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                }
            }
        };
        //手动ack
        channel.basicConsume("queue", false, consumer);
    }


    @PreDestroy
    public void destroy() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }

}
