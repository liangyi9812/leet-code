package com.edison.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author liangyi
 * @date 2024/3/10
 */
@Slf4j
class ArraySort20240310Test {

    /**
     * 冒泡排序
     *
     */
    @Test
    void bubbleSort() {
        int[] array = ArrayBase.buildArray();
        int length = array.length;
        log.info("array length: {}", length);
        for (int i = 0; i < length; i++) {
            if (i + 1 >= length) {
                log.info("final i: {}", i);
            }
            for (int j = 0; j < (length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        log.info(Arrays.toString(array));
    }

    @Test
    void selectionSort() {
        int[] array = ArrayBase.buildArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minimumIndex = i;
            for (int j = i; j < length - 1; j++) {
                // swap index i with minimum
                if (array[j + 1] < array[minimumIndex]) {
                    minimumIndex = j + 1;
                }
            }
            int temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
        log.info(Arrays.toString(array));
    }

    @Test
    void insertionSort() {
        int[] array = ArrayBase.buildArray();
        int length = array.length;

        for (int i = 1; i < length; i++) {
            // 当前需要排序的数组元素
            int check = array[i];
            int preIndex = i - 1;
            for (int j = preIndex; j >= 0; j--) {
                if (array[j] > check) {
                    array[j + 1] = array[j];
                } else {
                    // array[j] <= check
                    preIndex = j + 1;
                    break;
                }
            }
            array[preIndex] = check;
        }

        log.info(Arrays.toString(array));
    }

    @Test
    void insertionSort2() {
        int[] array = ArrayBase.buildArray();
        int length = array.length;
        int count = 0;
        for (int i = 1; i < length; i++) {
            count++;
            // 当前需要比较的数
            int current = array[i];
            // 已经排序好,最后一个数的下标
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > current) {
                count++;
                // 把当前preIndex覆盖到preIndex + 1 方便current插入
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }

        log.info(Arrays.toString(array));
        log.info("count: {}", count);
    }

    @Test
    void shellSort() {
        int[] array = ArrayBase.buildArray();
        int length = array.length;
        int gap = length / 2;
        int count = 0;
        while (gap > 0) {
            count++;
            for (int i = gap; i < length; i++) {
                count++;
                // 当前需要比较的数
                int current = array[i];
                // 已经排序好,最后一个数的下标
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current) {
                    count++;
                    // 把当前preIndex覆盖到preIndex + gap 方便current插入
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap = gap / 2;
        }

        log.info(Arrays.toString(array));
        log.info("count: {}", count);
    }

}
