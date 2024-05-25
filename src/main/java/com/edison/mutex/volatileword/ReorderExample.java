package com.edison.mutex.volatileword;

/**
 * @author liangyi
 * @date 2024/3/6
 */
public class ReorderExample {
    private int x = 0;
    private int y = 1;
    private volatile boolean flag = false;

    public void writer() {
        x = 42; //1
        y = 50; //2
        // 对一个volatile变量的写，happens-before于后续对这个volatile变量的读
        flag = true; //3
    }

    public void reader() {
        if (flag) { //4
            System.out.println("x:" + x); //5
            System.out.println("y:" + y); //6
        }
    }
}
