package com.edison.gc;

import com.edison.tools.Tool;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.ref.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/2
 */
class ReferenceDemoTest {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    @SneakyThrows
    void testStrongReference() {
        Object object1 = new Object();
        Object object2 = new Object();
        Tool.print("object1 -> " + object1);
        Tool.print("object2 -> " + object2);
        object1 = null;
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        Tool.print("After GC: object1 -> " + object1);
        Tool.print("After GC: object2 -> " + object2);
    }

    @Test
    @SneakyThrows
    void testSoftReference() {
        // -Xms5m -Xmx5m
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        SoftReference<Object> softReference = new SoftReference<>(obj, referenceQueue);
        // 取消强引用
        obj = null;
        Tool.print("创建obj和softReference, softReference -> " + softReference + ", obj -> " + obj);


        new Thread(() -> {
            Tool.print("开始监听引用队列");
            while (true) {
                Reference<?> polled = referenceQueue.poll();
                if (polled != null) {
                    Tool.print("实例被添加到了引用队列中, Reference polled -> " + polled + ", polled.get() -> " + polled.get());
                }
            }
        }, "queue-thread").start();
        TimeUnit.SECONDS.sleep(2);

        Tool.print("空间充足, 未开始gc, softReference -> " + softReference + ", softReference.get() -> " + softReference.get());
        Tool.print("开始第一次gc");
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        Tool.print("空间充足, 第一次gc后, softReference -> " + softReference + ", softReference.get() -> " + softReference.get());
        Tool.print("开始填充内存");
        try {
            byte[] bytes = new byte[1024 * 1024 * 4];
        } catch (Throwable throwable) {
            Tool.print(throwable);
        } finally {
            Tool.print("内存不足, softReference -> " + softReference + ", softReference.get() -> " + softReference.get());
        }

        countDownLatch.await();

    }

    @Test
    @SneakyThrows
    void testWeakReference() {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Reference<Object> weakReference = new WeakReference<>(obj, referenceQueue);
        // 取消强引用
        obj = null;
        Tool.print("创建obj和weakReference, weakReference -> " + weakReference + ", obj -> " + obj);


        new Thread(() -> {
            Tool.print("开始监听引用队列");
            while (true) {
                Reference<?> polled = referenceQueue.poll();
                if (polled != null) {
                    Tool.print("实例被添加到了引用队列中, Reference polled -> " + polled + ", polled.get() -> " + polled.get());
                }
            }
        }, "queue-thread").start();
        TimeUnit.SECONDS.sleep(2);

        Tool.print("空间充足, 未开始gc, weakReference -> " + weakReference + ", weakReference.get() -> " + weakReference.get());
        Tool.print("开始第一次gc");
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        Tool.print("空间充足, 第一次gc后, weakReference -> " + weakReference + ", weakReference.get() -> " + weakReference.get());
        Tool.print("开始填充内存");
        try {
            byte[] bytes = new byte[1024 * 1024 * 4];
        } catch (Throwable throwable) {
            Tool.print(throwable);
        } finally {
            Tool.print("内存不足, weakReference -> " + weakReference + ", weakReference.get() -> " + weakReference.get());
        }

        countDownLatch.await();
    }

    @Test
    @SneakyThrows
    void testPhantomReference() {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Reference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        // 取消强引用
//        obj = null;
        Tool.print("创建obj和phantomReference, phantomReference -> " + phantomReference + ", obj -> " + obj);


        new Thread(() -> {
            Tool.print("开始监听引用队列");
            while (true) {
                Reference<?> polled = referenceQueue.poll();
                if (polled != null) {
                    Tool.print("实例被添加到了引用队列中, Reference polled -> " + polled + ", polled.get() -> " + polled.get());
                }
            }
        }, "queue-thread").start();
        TimeUnit.SECONDS.sleep(2);

        Tool.print("空间充足, 未开始gc, phantomReference -> " + phantomReference + ", phantomReference.get() -> " + phantomReference.get());
        Tool.print("开始第一次gc");
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        Tool.print("空间充足, 第一次gc后, phantomReference -> " + phantomReference + ", phantomReference.get() -> " + phantomReference.get());
        Tool.print("obj -> " + obj);
        Tool.print("开始填充内存");
        try {
            byte[] bytes = new byte[1024 * 1024 * 4];
        } catch (Throwable throwable) {
            Tool.print(throwable);
        } finally {
            Tool.print("内存不足, phantomReference -> " + phantomReference + ", phantomReference.get() -> " + phantomReference.get());
            Tool.print("obj -> " + obj);
        }

        countDownLatch.await();
    }

}
