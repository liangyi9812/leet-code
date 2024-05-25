package com.edison.mutex.clh;

import com.edison.tools.Tool;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liangyi
 * @date 2024/3/5
 */
public class CLHLock2 {
    AtomicReference<QueueNode> tail = new AtomicReference<>(new QueueNode());

    ThreadLocal<QueueNode> pred;
    ThreadLocal<QueueNode> current;

    public CLHLock2() {
        current = ThreadLocal.withInitial(QueueNode::new);
        pred = ThreadLocal.withInitial(() -> null);
    }

    public void lock() {
        QueueNode node = current.get();
        node.locked = true;
        QueueNode pred = tail.getAndSet(node);
        this.pred.set(pred);
        while (pred.locked) {
        }
    }

    public void unlock() {
        QueueNode node = current.get();
        node.locked = false;
        QueueNode pred = this.pred.get();
        current.set(Tool.print(pred));
    }

    static class QueueNode {
        private volatile boolean locked = false;
    }
}
