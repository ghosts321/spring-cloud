package com.spring.cloud.configclient;

import com.spring.cloud.configclient.rabbitmq.entity.User;
import com.spring.cloud.configclient.rabbitmq.sender.DirectSender;
import com.spring.cloud.configclient.rabbitmq.sender.FanoutSender;
import com.spring.cloud.configclient.rabbitmq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    /**
     * Fanout测试
     *
     */
    @Test
    public void testFanout() {
        User user = new User();
        user.setId("1");
        user.setName("小陆砸");
        fanoutSender.send(user);
    }

    /**
     * DIRECT测试
     */
    @Test
    public void testDirect() {
        User user=new User();
        user.setId("1");
        user.setName("小陆砸呀");
        directSender.send(user);
    }

    /**
     * TOPIC测试
     */
    @Test
    public void testTopic() {
        User user=new User();
        user.setId("1");
        user.setName("小陆砸呀");
        topicSender.send(user);
    }
}