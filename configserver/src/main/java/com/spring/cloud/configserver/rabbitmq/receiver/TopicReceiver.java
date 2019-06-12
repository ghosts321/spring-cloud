package com.spring.cloud.configserver.rabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.configserver.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configserver.rabbitmq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/9
 */
@Component
public class TopicReceiver {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveTopic1监听到消息】" + user.toString());
    }
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveTopic2监听到消息】" + user.toString());
    }
}
