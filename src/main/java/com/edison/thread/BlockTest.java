package com.edison.thread;

/**
 * @author liangyi
 * @date 2024/2/27
 */
public class BlockTest {

    public static void main(String[] args) throws InterruptedException {
        BlockTest blockTest = new BlockTest();
        blockTest.blockedTest();
    }

    public void blockedTest() throws InterruptedException {

        Thread a = new Thread(() -> testMethod(), "a");
        Thread b = new Thread(() -> testMethod(), "b");

        a.start();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
