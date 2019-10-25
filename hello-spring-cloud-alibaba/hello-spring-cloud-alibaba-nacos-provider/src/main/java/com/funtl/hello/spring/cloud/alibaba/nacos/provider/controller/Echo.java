package com.funtl.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Echo {
    @Value("${server.port}")
    private String port;

    @Value("${author.name}")
    private String name;

    @GetMapping(value = "/echo/{message}")
    public String echo1(@PathVariable String message) {
        return "Hello Nacos" + message +" from "+ port+" "+name;
    }

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    // 从上下文中读取配置
    @GetMapping(value = "/hi")
    public String sayHi() {
        return "Hello " + applicationContext.getEnvironment().getProperty("author.name");
    }
}
