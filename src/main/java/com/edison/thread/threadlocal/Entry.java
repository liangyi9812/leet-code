package com.edison.thread.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author liangyi
 * @date 2024/3/3
 */
public class Entry {

    WeakReference<ThreadLocal<?>> key;
    Object value;

}
