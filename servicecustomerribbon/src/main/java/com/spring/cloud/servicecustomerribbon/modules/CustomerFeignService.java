package com.spring.cloud.servicecustomerribbon.modules;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@FeignClient(value = "service-producer")
public interface CustomerFeignService {

    @RequestMapping("hello")
    String hello(@RequestParam String name);

}
