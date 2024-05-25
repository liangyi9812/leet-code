package com.edison.mutex.clh;

import com.edison.tools.Tool;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liangyi
 * @date 2024/3/4
 */
public class CLHLock {
    private final ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public void lock() {
        Node node = this.node.get();
        node.state = 1;
        Node preNode = tail.getAndSet(node);
        while (preNode.state != 0) {
            // 自旋等待 preNode state 为 0 相当于preNode释放锁
        }
        // 当preNode为false时 获取到了锁
        Tool.print("got lock");
    }

    public void unlock() {
        final Node node = this.node.get();
        node.state = 0;
        this.node.set(new Node());
    }

    private static class Node {
        private volatile int state = 0;
    }

}
