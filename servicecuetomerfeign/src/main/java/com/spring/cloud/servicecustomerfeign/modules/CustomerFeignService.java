package com.spring.cloud.servicecustomerfeign.modules;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@FeignClient(value = "service-producer", fallback = FeignServiceHystrixImpl.class)
public interface CustomerFeignService {

    @RequestMapping("hello")
    String hello(@RequestParam(value = "name") String name);
}
