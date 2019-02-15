package com.drawinds.blog.usercenter.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:19
 * Description:
 */
@Configuration
public class RabbitMQReceiver {

    @RabbitListener(queues = "queue")
    public void process(String message){
        System.out.println(message);
    }
}
