package com.per.thread;

/**
 * @author lYS
 * @date 2020/9/23 0023
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(this.getName()+i);
            try {
                MyThread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("我是继承了Thread类的线程");
        myThread.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("我是继承了Thread类的线程二");
        myThread2.start();
        System.out.println("主线程结束"+ Thread.currentThread() );
    }
}
