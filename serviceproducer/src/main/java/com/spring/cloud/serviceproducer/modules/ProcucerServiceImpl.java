package com.spring.cloud.serviceproducer.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@Service
public class ProcucerServiceImpl implements ProducerService{

    @Autowired
    RestTemplate restTemplate;


    @Override
    public String hello(String name) {
        return restTemplate.getForObject("http://service-customer-ribbon/hello1?name="+name,String.class);
    }
}
