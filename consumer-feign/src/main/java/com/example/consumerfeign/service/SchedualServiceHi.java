package com.example.consumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhankun
 * @Date 2018/5/8 10:24
 */
//通过调用@FeignClient("服务名")来指定调用eureka的哪个服务
@FeignClient(value = "provider")
public interface SchedualServiceHi {

    @RequestMapping(value = "provider/hi", method = RequestMethod.GET)
    String sayHiFromProvider(@RequestParam(value = "name") String name);
}
