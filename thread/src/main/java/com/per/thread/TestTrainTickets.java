package com.per.thread;

/**
 * @Description: TODO 依据火车站售票窗口练习多线程  以及 同步锁
 * @Author: lys
 * @Date: 2020-10-20 16:04
 * @Version: 1.3.*
 */
public class TestTrainTickets implements Runnable{

    private int ticketNum = 100;
    @Override
    public  void run() {
        while (ticketNum>0) {
            System.out.println("剩余的票数"+ticketNum);
            ticketNum--;
        }

    }

    public static void main(String[] args) {
        TestTrainTickets tickets = new TestTrainTickets();
        new Thread(tickets).start();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }
}
