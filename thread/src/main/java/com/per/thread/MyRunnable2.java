package com.per.thread;

/**
 * @author lYS
 * @date 2020/9/25 0025
 */
public class MyRunnable2 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
      
    }
}
