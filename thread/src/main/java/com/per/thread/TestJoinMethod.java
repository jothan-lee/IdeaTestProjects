package com.per.thread;

/**
 * @Description: TODO 对join()方法的理解   ：等待调用join()方法的线程执行结束，程序才会继续执行下去
 * @Author: lys
 * @Date: 2020-10-20 14:47
 * @Version: 1.3.*
 */
public class TestJoinMethod  {



    public static void main(String[] args){
            System.out.println("MainThread run start.");
            //启动一个子线程
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadA run start.");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadA run finished.");
                }
            });
            threadA.start();

            System.out.println("MainThread join before");
            try {
                threadA.join();    //调用join()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MainThread run finished.");
        }



}
