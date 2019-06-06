package com.spring.cloud.serviceproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JiangJunpeng
 * @date 2019/6/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProducerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
