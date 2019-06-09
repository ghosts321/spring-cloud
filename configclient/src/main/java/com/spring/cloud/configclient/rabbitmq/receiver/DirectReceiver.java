package com.spring.cloud.configclient.rabbitmq.receiver;

import com.spring.cloud.configclient.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configclient.rabbitmq.entity.User;
import org.jboss.logging.Logger;
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
    private static final Logger LOGGER = Logger.getLogger(DirectReceiver.class);
    
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect1(User user) {

        LOGGER.info("【receiveDirect1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect2(User user) {

        LOGGER.info("【receiveDirect2监听到消息】" + user);
    }
}
