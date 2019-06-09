package com.spring.cloud.configserver.rabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.configserver.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configserver.rabbitmq.entity.User;
import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by JiangJunpeng on 2019/6/9.<br>
 */
@Component
public class FanoutReceiver {

    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(FanoutReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveFanout1监听到消息】" + user.toString());
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic2(String message) {

        User user = JSON.parseObject(message, User.class);

        LOGGER.info("【receiveFanout2监听到消息】" + user.toString());
    }
}