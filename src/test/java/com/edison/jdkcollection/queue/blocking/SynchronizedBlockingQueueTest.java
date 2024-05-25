package com.edison.jdkcollection.queue.blocking;

import com.edison.BaseTest;
import com.edison.tools.Tool;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/4
 */
class SynchronizedBlockingQueueTest extends BaseTest {

    @Test
    void test() {
        Tool.print("current thread is daemon -> " + Thread.currentThread().isDaemon());
        SynchronizedBlockingQueue queue = new SynchronizedBlockingQueue(10);
        final int range = 20;
        // 线程不断放置元素
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < range; i++) {
                try {
                    queue.put("element" + i);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "put-thread");
        Tool.print("putThread.isDaemon() -> " + putThread.isDaemon());
        putThread.start();

        // 线程取出元素
        new Thread(() -> {
            for (int i = 0; i < range; i++) {
                try {
                    queue.take();
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "take-thread").start();

    }
}
