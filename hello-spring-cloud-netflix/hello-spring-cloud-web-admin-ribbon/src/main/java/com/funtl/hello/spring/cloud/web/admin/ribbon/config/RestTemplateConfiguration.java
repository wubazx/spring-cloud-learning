package com.funtl.hello.spring.cloud.web.admin.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced//有多个Eureka服务器或是多个服务提供者，以负载均衡的方式访问
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
