package com.per.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lYS
 * @date 2020/9/29 0029
 */
public class MyThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值的线程池1
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.shutdown();
        //没有返回值的线程池2
        ExecutorService service1 = Executors.newFixedThreadPool(5);
        service1.execute(new MyRunnable());
        service1.execute(new MyRunnable());
        service1.shutdown();

        //有返回值的线程池1
        ExecutorService service3 = Executors.newFixedThreadPool(5);
        Future<?> result1 = service3.submit(new MyCallable());
        Object o = result1.get();
        System.out.println("o = " + o);
        Future<?> result2 = service3.submit(new MyCallable());
        Object o3 = result2.get();
        System.out.println("o3 = " + o3);
        service3.shutdown();

    }
}
