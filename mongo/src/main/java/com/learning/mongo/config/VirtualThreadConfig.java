package com.learning.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
public class VirtualThreadConfig {

    @Bean("virtualThreadService")
    public ExecutorService virtualThreadExecutor(){
        ThreadFactory threadFactory = Thread.ofVirtual().name("mongo-vt-",0).factory();
        return Executors.newThreadPerTaskExecutor(threadFactory);
        //return Executors.newVirtualThreadPerTaskExecutor();
    }
}
