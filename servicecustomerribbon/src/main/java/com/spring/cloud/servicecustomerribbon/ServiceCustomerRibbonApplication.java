package com.spring.cloud.servicecustomerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangJunpeng
 * @date 2019/6/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceCustomerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerRibbonApplication.class, args);
    }

    //LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
