package com.edison.mutex;

import com.edison.tools.Tool;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liangyi
 * @date 2024/3/5
 */
public class ParkInterruptDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new ParkThread(), "ParkThread");
        t.start();
        Tool.sleepSeconds(1);
        Tool.print("开始interrupt");
        t.interrupt();

    }

    static class ParkThread implements Runnable{

        @Override
        public void run() {
            Tool.print("开始阻塞");
            LockSupport.park();
            Tool.print("结束阻塞: Thread.interrupted() ->" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            Tool.print("第二次结束阻塞: Thread.interrupted() ->" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            Tool.print("第三次结束阻塞: Thread.interrupted() ->" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            Tool.print("第四次结束阻塞: Thread.interrupted() ->" + Thread.currentThread().isInterrupted());
        }
    }
}
