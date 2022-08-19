package com.edison.fookjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author LiangYi
 * @date 2022-7-26
 */
public class PrintForkJoin extends RecursiveAction {

    int offset = 0;

    public PrintForkJoin(int[] nums) {
        int count = 0;
        for (int j = offset; j < 10 + offset; j++) {
            System.out.println(nums[j]);
        }
        count++;
        System.out.println(count);
    }

    @Override
    protected void compute() {

    }


}
