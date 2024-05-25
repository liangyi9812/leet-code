package com.edison.mutex.clh;

import com.edison.BaseTest;
import com.edison.tools.Tool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


/**
 * @author liangyi
 * @date 2024/3/5
 */

class CLHLockTest extends BaseTest {

    @Test
    void testLock() throws InterruptedException {
        CLHLock lock = new CLHLock();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    Tool.sleepSeconds(2);
                } finally {
                    lock.unlock();
                }
            }, "clh-" + i).start();
        }
        LATCH.await();
    }

    @Test
    void testJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Tool.print("start");
            Tool.sleepSeconds(10);
            Tool.print("end");
        });
        thread.start();
        thread.join(2000);
    }

    @Test
    void testThreadJoin() {
        class SleepThread extends Thread {
            private final int sleepSeconds;

            SleepThread(int sleepSeconds) {
                this.sleepSeconds = sleepSeconds;
            }

            SleepThread(int sleepSeconds, String name) {
                super(name);
                this.sleepSeconds = sleepSeconds;
            }

            @Override
            public void run() {
                Tool.print("start");
                Tool.sleepSeconds(sleepSeconds);
                Tool.print("end");
            }
        }
        SleepThread thread1 = new SleepThread(20, "thread1");
        SleepThread thread2 = new SleepThread(5, "thread2");
        thread1.start();
        thread2.start();

        ArrayList<Thread> list = new ArrayList<>();
        list.add(thread1);
        list.add(thread2);
        list.forEach(thread -> {
            try {
                Tool.print("join " + thread.getName());
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


    }

}
