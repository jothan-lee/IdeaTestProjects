package com.per.thread;

/**
 * @Description: TODO 线程的通信
 * @Author: lys
 * @Date: 2020-11-06 15:40
 * @Version: 1.3.*
 */
public class Communication implements Runnable {
    int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() +
                            ":" + i++);
                } else
                    break;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Communication communication = new Communication();
        new Thread(communication,"1线程").start();
        new Thread(communication,"2线程").start();
    }
}
