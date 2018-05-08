package com.example.consumerfeign.controller;

import com.example.consumerfeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhankun
 * @Date 2018/5/8 10:37
 */
@RestController
@RequestMapping(value = "feign")
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "sayHi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name) {
        return schedualServiceHi.sayHiFromProvider(name);
    }
}
