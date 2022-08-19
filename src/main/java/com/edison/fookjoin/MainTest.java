package com.edison.fookjoin;

import java.util.concurrent.FutureTask;

/**
 * @author LiangYi
 * @date 2022-7-26
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        Thread[] threads = new Thread[2];
        Integer offset = 0;
        for (int i = 0; i < threads.length; i++) {
            final int finalOffset = offset;
            FutureTask<Integer> task = new FutureTask<>(() -> {
                int count = 0;
                for (int j = finalOffset; j < 10 + finalOffset; j++) {
                    System.out.println(nums[j]);
                }
                count++;
                return count;
            });
            Thread cur = new Thread(task);
            cur.start();
            threads[i] = cur;
            offset += 10;
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(offset);
    }

}
