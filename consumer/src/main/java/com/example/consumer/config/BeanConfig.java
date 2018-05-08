package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhankun
 * @Date 2018/5/8 13:30
 * @Description: 线程池配置
 */
@Configuration
@EnableAsync
public class BeanConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(5);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(8);
        //设置队列容量
        taskExecutor.setQueueCapacity(10);
        //设置线程活跃时间
        taskExecutor.setKeepAliveSeconds(60);
        //设置默认线程名称
        taskExecutor.setThreadNamePrefix("test-");
        // 设置拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return taskExecutor;
    }
}
