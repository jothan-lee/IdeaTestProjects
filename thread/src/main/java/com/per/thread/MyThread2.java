package com.per.thread;

/**
 * @author lYS
 * @date 2020/9/23 0023
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(this.getName()+i);
            try {
                MyThread2.sleep(1000);
                System.out.println("睡了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
