package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-1
 */
public class LeetCode852 {

    public static void main(String[] args) {
        int[] nums = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(peakIndexInMountainArray2(nums));

    }


    /**
     * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
     * 输出：2
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 1] > arr[i] && arr[i + 1] > arr[i + 2]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        int l = 0;
        int r = arr.length - 2;

        // 在[0, n-2)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
