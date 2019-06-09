package com.spring.cloud.configclient.rabbitmq.sender;

import com.spring.cloud.configclient.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configclient.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/9
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 第一个参数：TopicExchange名字
    // 第二个参数：Route-Key
    // 第三个参数：要发送的内容
    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,"jl.message", user);
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "jl.ljh", user);
    }
}