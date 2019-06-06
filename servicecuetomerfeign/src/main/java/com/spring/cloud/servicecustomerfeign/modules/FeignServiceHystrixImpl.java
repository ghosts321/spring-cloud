package com.spring.cloud.servicecustomerfeign.modules;

import org.springframework.stereotype.Service;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@Service
public class FeignServiceHystrixImpl implements CustomerFeignService{

    @Override
    public String hello(String name) {
        return "sorry "+name+"，service has fail!";
    }
}
