package com.edison.mutex.clh;

import com.edison.BaseTest;
import com.edison.tools.Tool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liangyi
 * @date 2024/3/5
 */
class CLHLock2Test extends BaseTest {

    @Test
    void testLock() throws InterruptedException {
        CLHLock2 lock = new CLHLock2();

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

}
