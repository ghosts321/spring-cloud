package com.spring.cloud.configclient.rabbitmq.sender;

import com.spring.cloud.configclient.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configclient.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JiangJunpeng on 2019/6/9.<br>
 */
@Component
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "direct.jjp", user);
    }
}