package com.drawinds.blog.advertisement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:11
 * Description:
 */
@SpringBootTest(classes = AdvertisementApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitMQTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test(){
        amqpTemplate.convertAndSend("queue","hello,usercenter");
    }
}
