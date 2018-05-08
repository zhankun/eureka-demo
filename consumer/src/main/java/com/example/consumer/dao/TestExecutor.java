package com.example.consumer.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author zhankun
 * @Date 2018/5/8 13:59
 */
@Component
public class TestExecutor {
    @Async
    public void test(int i) {
        System.out.println(String.format("第%s次循环,线程id:%s", i, Thread.currentThread().getId()));
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public ListenableFuture<Integer> testAsyncReturn(int i) {
        System.out.println(String.format("第%s次循环,线程id:%s", i, Thread.currentThread().getId()));
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(i);
    }
}
