package com.edison.mutex.concurrent;

/**
 * @author liangyi
 * @date 2024/3/1
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

public class ConditionExample {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    final Queue<String> queue = new LinkedList<>();
    private final int queueSize = 10;

    class Producer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.size() == queueSize) {
                    notFull.await();
                }
                queue.add("element");
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    notEmpty.await();
                }
                String element = queue.remove();
                System.out.println("Element taken from the queue: " + element);
                notFull.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}
