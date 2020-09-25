package com.per;

import static org.junit.Assert.assertTrue;

import com.per.thread.MyThread;
import com.per.thread.MyThread2;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 注意：测试类线程执行睡眠sleep（）后次线程后面的程序不能进行，用main方法就不会出现这个问题
     */
    @Test
    public void myThreadTest() {
        MyThread myThread = new MyThread();
        myThread.setName("我是继承了Thread类的线程");
        myThread.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("我是继承了Thread类的线程二");
        myThread2.start();
       System.out.println("主线程结束"+ Thread.currentThread() );

    }
}
