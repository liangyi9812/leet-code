package com.edison.mutex;

import com.edison.tools.Tool;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liangyi
 * @date 2024/3/5
 */
public class ParkDemo {
    public static void main(String[] args) {

        Tool.print("开始运行");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        Tool.print("第一次park结束");
        LockSupport.park();
        Tool.print("第二次park结束");
        Tool.print("运行结束");

    }
}
