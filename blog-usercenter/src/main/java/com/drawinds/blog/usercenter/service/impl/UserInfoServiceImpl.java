package com.drawinds.blog.usercenter.service.impl;

import com.drawinds.blog.usercenter.service.UserInfoService;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:59
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public int addUser(String username) throws Exception {
        //1.添加订单记录
        String orderId = UUID.randomUUID().toString();
        String sql = "insert into table_order (order_id,user_id,order_content,create_time) values (?,?,?,now())";
        int count = this.getJdbcTemplate().update(sql, new Object[]{orderId, userId, orderContent});
        if (count != 1) {
            throw new Exception("订单创建失败，原因[数据库操作失败]");
        }
        //2.调用优惠券接口
//        RestTemplate restTemplate=createRestTemplate();
//        String httpUrl="http://localhost:8080/OrderDiscount/coupon/lock.action?orderId="+orderId+"&couponId="+couponId;
//        String result=restTemplate.getForObject(httpUrl, String.class);
//        if(!"ok".equals(result)){
//            throw new Exception("订单创建失败：原因[调用优惠券接口失败]");
//        }
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();//创建连接
        Channel channel = connection.createChannel();//打开通道，发送消息
        channel.exchangeDeclare("exchange", BuiltinExchangeType.FANOUT);
        //定义一个交换机，用于传送消息至对应的队列中去
        channel.queueDeclare("queue", true, false, false, null);
        //定义一个queue队列,，true表示持久化
        channel.queueBind("queue", "exchange", "*");//配置绑定关系，才能指定消息发送到哪个队列
        //2.2发送消息
        channel.confirmSelect();
        String message = username;
        channel.basicPublish("exchange", "", null, message.getBytes());
        channel.waitForConfirmsOrDie();//等待rabbitmq确认
        //2.3断开链接
        channel.close();
        connection.close();
        return 0;
    }

    //创建一个HTTP请求工具类
    public RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        //连接超时时间>3秒
        requestFactory.setConnectTimeout(3000);
        //处理超时时间>2秒
        requestFactory.setReadTimeout(2000);
        return new RestTemplate(requestFactory);
    }

}
