package com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix;

import com.funtl.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component//注入到IO容器中
public class AdminServiceHystrix implements AdminService {
    @Override
    public String helloEurekaServer(String message) {
        return String.format("message:%s,but required error!",message);
    }
}
