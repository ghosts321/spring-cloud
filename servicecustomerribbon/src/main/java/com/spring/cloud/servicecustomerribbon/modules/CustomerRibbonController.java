package com.spring.cloud.servicecustomerribbon.modules;

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
public class CustomerRibbonController {

    @Autowired
    CustomerRibbonService customerRibbonService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return customerRibbonService.hello(name);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return "你好 " + name + "，我是端口号：" + port + "的服务者";
    }
}
