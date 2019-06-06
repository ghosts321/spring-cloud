package com.spring.cloud.serviceproducer.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/5
 */
@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "你好 " + name + "，我是端口号：" + port + "的生产者";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name){
        return producerService.hello(name);
    }
}
