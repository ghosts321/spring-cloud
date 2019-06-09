package com.spring.cloud.configclient.rabbitmq.receiver;

import com.spring.cloud.configclient.rabbitmq.config.RabbitConfig;
import com.spring.cloud.configclient.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by JiangJunpeng on 2019/6/9.<br>
 */
@Component
public class FanoutReceiver {

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(User user) {
        System.out.println("【receiveFanout1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveFanout2监听到消息】" + user);
    }
}