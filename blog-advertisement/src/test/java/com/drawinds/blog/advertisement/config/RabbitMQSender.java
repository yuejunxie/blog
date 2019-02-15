package com.drawinds.blog.advertisement.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:12
 * Description:
 */
@Configuration
public class RabbitMQSender {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}
