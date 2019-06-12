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
public class DirectReceiver {
    
    /**
     * logger 
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect1(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveDirect1监听到消息】" + user.toString());
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect2(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveDirect2监听到消息】" + user.toString());
    }
}
