package com.edison.leftgod.stackandqueue.minstack;

import java.util.Objects;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author LiangYi
 * @date 2022/4/7
 * @note
 */
public class MiniStack<T extends Comparable<T>> {

    private final Stack<T> stackData;
    private final Stack<T> miniStore;

    public MiniStack() {
        this.stackData = new Stack<>();
        this.miniStore = new Stack<>();
    }

    public void push(T t) {
        Objects.requireNonNull(t, "element to push can‘t be null");
        stackData.push(t);
        if (miniStore.isEmpty()) {
            miniStore.push(t);
        } else if (t.compareTo(miniStore.peek()) < 1) {
            miniStore.push(t);
        }
    }

    public void pop() {
        T pop = stackData.pop();
        if (miniStore.peek() == pop) {
            miniStore.pop();
        }
    }

    public T getMin() {
        return miniStore.peek();
    }

}
