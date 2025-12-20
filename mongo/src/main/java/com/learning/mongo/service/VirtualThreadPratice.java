package com.learning.mongo.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.sleep;

@Slf4j

public class VirtualThreadPratice {
   static ThreadFactory factory = Thread.ofVirtual().name("my_virtual_thread-",0).factory();
   static ExecutorService executorService = Executors.newThreadPerTaskExecutor(factory);

    @SneakyThrows
    public static void main(String args[]){

       int totalcoreProcessor = Runtime.getRuntime().availableProcessors();
       log.info("total core in this system:{}",totalcoreProcessor);
        sleeping();
        play();

    }


    static void play(){
         virtualThread("Play Time",
                ()->{
                    log.info("I am playing...");
                    try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("I am done with Playing....");
                }
        );
    }
    static void sleeping(){
         virtualThread("Sleep Time",
                ()->{
                    log.info("I am Sleeping");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("I am done with Sleeping....");
                }
        );
    }

    @SneakyThrows
    private static Thread  createVirtualThread(String name,Runnable runnable){
       // return Thread.ofVirtual().name("routine",0).start(runnable);
        ThreadFactory factory = Thread.ofVirtual().name("my_virtual_thread-",0).factory();
        Thread virtualThreadFromAFactory = factory.newThread(runnable);
        return virtualThreadFromAFactory;
    }

@SneakyThrows
    private static void  virtualThread(String name,Runnable runnable){
        var future = executorService.submit(runnable);
        future.get();
    }
}
