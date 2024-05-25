package com.edison.base;

import java.util.LinkedList;

/**
 * @author liangyi
 * @date 2024/3/11
 */
public class Stack<E> {

    private final LinkedList<E> list = new LinkedList<>();

    public void push(E e) {
        list.push(e);
    }

    public E pop() {
        return list.pop();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E element() {
        return list.element();
    }
}
