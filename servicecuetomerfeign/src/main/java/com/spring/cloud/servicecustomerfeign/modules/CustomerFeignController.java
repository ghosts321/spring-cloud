package com.spring.cloud.servicecustomerfeign.modules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@RestController
public class CustomerFeignController {

    @Value("${spring.application.name}")
    String applicationName;

    @Resource
    private CustomerFeignService customerFeignService;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return customerFeignService.hello(name+", from "+applicationName);
    }
}
