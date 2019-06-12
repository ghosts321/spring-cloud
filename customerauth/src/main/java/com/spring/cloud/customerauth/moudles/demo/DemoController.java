package com.spring.cloud.customerauth.moudles.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/11
 */
@RestController
@RequestMapping("/user")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/getUser")
    public List<Demo> getUser(){
        return demoService.findAll();
    }
}
