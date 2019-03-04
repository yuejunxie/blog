package com.drawinds.mq.web.restful;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/2 20:49
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MQRestful {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String send(String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("my-topic", msg);
        try {
            SendResult<String, String> sendResult = future.get();
            return "success";
        } catch (InterruptedException | ExecutionException e) {
            log.error("", e);
        }
        return "fail";
    }

    @KafkaListener(topics = "my-topic")
    public void listen(ConsumerRecord<?, ?> record) {
        log.error(record.topic() + record.offset() + record.value());
    }
}
