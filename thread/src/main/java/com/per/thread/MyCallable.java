package com.per.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author lYS
 * @date 2020/9/29 0029
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
        return "实现Callable接口的实现类完成多线程执行完毕";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> result = new FutureTask<String>(myCallable);
        Thread thread = new Thread(result);
        thread.setName("实现Callable接口实现多线程");
        thread.start();
        //等所有线程执行完，获取值
        String s = result.get();
        System.out.println("s = " + s);
    }
}
