package com.per.thread;

/**
 * @author lYS
 * @date 2020/9/25 0025
 */
public class MyRunnable implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }

    }

    public static void main(String[] args) {
        //对两个实现类分别启动一个线程
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        Thread thread1 = new Thread(myRunnable);
        thread.setName("我是实现runnable接口创建的线程");
        thread.start();
        thread1.setName("我是实现runnable接口创建的线程一");
        thread1.start();

        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread2 = new Thread(myRunnable2);
        thread2.setName("我是实现runnable接口创建的线程二");
        thread2.start();
//        //对一个实现类启动两个线程

        MyRunnable myRunnable3 = new MyRunnable();
        Thread thread3 = new Thread(myRunnable3);
        thread3.setName("我是实现runnable接口创建的线程三");
        Thread thread4 = new Thread(myRunnable3);
        thread4.setName("我是实现runnable接口创建的线程四");
        thread3.start();
        thread4.start();

//用匿名内部类的形式实现多线程
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        },"我是实现runnable接口创建的线程五");
        thread5.start();


//用lambada表达式形式实现的多线程
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                  System.out.println(Thread.currentThread().getName() + i);
                }
        },"我是实现runnable接口创建的线程六").start();

    }
}
