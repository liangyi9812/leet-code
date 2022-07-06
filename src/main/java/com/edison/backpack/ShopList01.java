package com.edison.backpack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LiangYi
 * @date 2022-7-5
 */
public class ShopList01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();

        Goods[] goods = new Goods[m];
        for (int i = 0; i < m; i++) {
            goods[i] = new Goods();
        }
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i].v = v;
            goods[i].p = p * v;  // 直接用p*v，方便后面计算
            if (q == 0) {
                goods[i].main = true;
            } else {
                if (goods[q - 1].a1 == -1) {
                    goods[q - 1].a1 = i;
                } else {
                    goods[q - 1].a2 = i;
                }
            } 
        }
        System.out.println(Arrays.toString(goods));
    }

}

class Goods {
    int v;
    int p;
    boolean main = false;

    int a1 = -1;  //定义附件1的编号
    int a2 = -1;  //定义附件2的编号
}
