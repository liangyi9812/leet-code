package com.edison.gc;

import com.edison.tools.Tool;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/2
 */
public class PhantomReferenceTest {

    private static PhantomReferenceTest reference;
    private static ReferenceQueue queue;


    public static void main(String[] args) {
        reference = new PhantomReferenceTest();
        //引用队列
        queue = new ReferenceQueue<>();
        //虚引用
        PhantomReference<PhantomReferenceTest> phantomReference = new PhantomReference<>(reference, queue);

        Thread thread = new Thread(() -> {
            PhantomReference<PhantomReferenceTest> r = null;
            while (true) {
                if (queue != null) {
                    r = (PhantomReference<PhantomReferenceTest>) queue.poll();
                    //说明被回收了,得到通知
                    if (r != null) {
                        Tool.print("实例被添加到了引用队列中, PhantomReference -> " + r);
                    }
                }
            }
        }, "queue-thread");
        thread.setDaemon(true);
        thread.start();

        //null (获取不到虚引用)
        Tool.print("gc前也获取不到虚引用 phantomReference.get() -> " + phantomReference.get());
        try {
            reference = null;
            Tool.print("开始gc");
            //第一次GC 引用不可达 守护线程执行finalize方法 重新变为可达对象
            System.gc();
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
