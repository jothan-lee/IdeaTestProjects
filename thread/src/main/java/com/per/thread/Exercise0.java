package com.per.thread;

/**
 * @author lYS
 * @date 2020/10/19 0019
 */
public class Exercise0 {

    private static int  j = 100;
    //练习一：创建两个分线程，让其中一个线程输出1-100之间的偶数，另一个线程输出1-100之间的奇数。
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //输出偶数
                for (int i = 2; i < j; i += 2) {
                    System.out.println(Thread.currentThread() + String.valueOf(i));
                }
            }
        },"输出偶数的线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //输出奇数
                for (int i = 1; i < j; i += 2) {
                    System.out.println(Thread.currentThread() + String.valueOf(i));
                }
            }
        },"输出奇数的线程").start();

    }


}
