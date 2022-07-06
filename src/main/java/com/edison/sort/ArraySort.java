package com.edison.sort;

import java.util.Arrays;

/**
 * @author LiangYi
 * @date 2022-6-19
 */
public class ArraySort {

    public static void main(String[] args) {
        //int[] array = ArrayBase.buildArray();
        int[] array = new int[]{7, 4, 9, 3, 6, 5, 8, 1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void popSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        // i = 1 默认数组第一位以及排好序
        for (int i = 1; i < array.length; i++) {
            // 已排序数组的长度
            int j = i - 1;
            // 需要排序的数
            int key = array[i];
            // j >= 0 防止需要排序的数是最小的， 当已排序的第j位比key大
            while (j >= 0 && array[j] > key) {
                // 则平行移动覆盖
                array[j + 1] = array[j];
                j--;
            }
            // 把 key 插入到 j + 1 位上
            array[j + 1] = key;
        }
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int left, int right) {

        if (left > right) {
            return;
        }
        // base
        int pivot = array[left];
        int i = left, j = right;

        while (i < j) {
            while (pivot <= array[j] && i < j) {
                j--;
            }

            while (pivot >= array[i] && i < j) {
                i++;
            }

            // 如果i<j，交换它们
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = pivot;

        quick(array, left, i - 1);
        quick(array, i + 1, right);
    }
}
