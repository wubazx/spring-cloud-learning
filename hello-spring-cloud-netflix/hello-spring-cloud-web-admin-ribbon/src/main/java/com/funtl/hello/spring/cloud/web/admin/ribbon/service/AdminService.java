package com.funtl.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {
    //通过Ribbon+RestTemplate调用Eureka中的提供者服务

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(String msg){
        return restTemplate.getForObject("http://hello-spring-cloud-service-admin/hello?message="+msg,String.class);
    }

    public String hiError(String msg) {
        return "Hi，your message is :\"" + msg + "\" but request error.";
    }
}
