package com.spring.cloud.configclient.rabbitmq.receiver;

import com.spring.cloud.configclient.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configclient.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/9
 */
@Component
public class TopicReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(User user) {
        System.out.println("【receiveTopic1监听到消息】" + user.toString());
    }
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveTopic2监听到消息】" + user.toString());
    }
}
