package com.spring.cloud.servicecustomerribbon.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/5
 */
@Service
public class CustomerRibbonServiceImpl implements CustomerRibbonService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String hello(String name) {

        return restTemplate.getForObject("http://service-producer/hello?name="+name,String.class);
    }
}
