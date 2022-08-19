package com.edison.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author LiangYi
 * @date 2022-8-14
 */
public class LeetCode1422 {

    public static void main(String[] args) {
        String str = "0100110001011111011011010010001111000100110011101110001001111010010011001111000";
        System.out.println(maxScore(str));
    }

    public static int maxScore(String s) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
        int length = s.length();
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            completableFutures.add(maxLength(s, i, executor));
        }

        // execute
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        try {
            Integer res = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).
                    thenApply(v -> completableFutures.stream().map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }).max(Integer::compareTo)).get().orElseThrow(() -> new RuntimeException("error"));
            executor.shutdown();
            return res;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static CompletableFuture<Integer> maxLength(String str, int index, Executor executor) {
        char[] chars = str.toCharArray();
        return CompletableFuture.supplyAsync(() -> {
            int left = 0, right = 0;
            for (int i = 0; i < chars.length; i++) {
                if (i <= index) {
                    if (chars[i] == '0') {
                        left++;
                    }
                } else {
                    if (chars[i] == '1') {
                        right++;
                    }
                }
            }
            System.out.println("return: " + (left + right));
            return left + right;
        }, executor);
    }

}
