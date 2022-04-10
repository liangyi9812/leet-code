package com.edison.leftgod.minstack;

import java.util.Stack;

/**
 * @author LiangYi
 * @data 2022/4/10
 * @note
 */
public class TwoStackQueue<T> {

    private final Stack<T> tempStack;
    private final Stack<T> queueDataStack;

    public TwoStackQueue() {
        tempStack = new Stack<>();
        queueDataStack = new Stack<>();
    }

    public void add(T item) {
        tempStack.push(item);
    }

    public T poll() {
        transfer();
        return queueDataStack.pop();
    }

    public T peek() {
        transfer();
        return queueDataStack.peek();
    }

    private void transfer() {
        while (!tempStack.isEmpty()) {
            queueDataStack.push(tempStack.pop());
        }
    }
}
