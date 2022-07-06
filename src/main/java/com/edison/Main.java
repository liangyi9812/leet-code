package com.edison;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LiangYi
 * @date 2022-7-4
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //用于记录输入的n个整数
        int[] arr = new int[n];
        //用于存储所有的奇数
        List<Integer> odds = new ArrayList<>();
        //用于存储所有的偶数
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if ((num & 1) == 1) {
                odds.add(num);
            } else {
                evens.add(num);
            }
        }
        int[] matchedEven = new int[evens.size()];
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
