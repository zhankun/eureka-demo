package com.example.consumer.controller;

import com.example.consumer.dao.TestExecutor;
import com.example.consumer.service.HelloService;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhankun
 * @Date 2018/5/7 17:42
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private TestExecutor executor;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @RequestMapping(value = "testTaskExecutor")
    public String testTaskExecutor() {
        for (int i = 0; i <= 15; i++) {
            executor.test(i);
        }
        return "success";
    }

    @RequestMapping(value = "testReturn")
    public String testReturn() throws ExecutionException, InterruptedException, TimeoutException {
        for (int i = 0; i <= 8; i++) {
            ListenableFuture<Integer> future = executor.testAsyncReturn(i);
            //Integer num = future.completable().get();
            Integer num = future.completable().get(70, TimeUnit.SECONDS);
            System.out.println(String.format("<----我是第%s个循环---->", num));
        }
        return "error";
    }
}
