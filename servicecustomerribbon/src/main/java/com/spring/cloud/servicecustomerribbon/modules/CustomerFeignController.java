package com.spring.cloud.servicecustomerribbon.modules;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@RestController
public class CustomerFeignController {

    @Resource
    private CustomerFeignService customerFeignService;

    @RequestMapping("/hellofeign")
    public String hello(@RequestParam String name){
        return customerFeignService.hello(name);
    }
}
