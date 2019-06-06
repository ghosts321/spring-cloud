package com.spring.cloud.servicecustomerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/6
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceCustomerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerFeignApplication.class, args);
    }
}
