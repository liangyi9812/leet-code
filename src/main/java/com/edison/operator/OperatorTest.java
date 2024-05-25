package com.edison.operator;

public class OperatorTest {
    public static void main(String[] args) {

        // 移位运算符
        // 正数
        int b1 = 0b0100_0000_0000_0000_0000_0000_0000_1010;
        System.out.println("b1: " + b1);
        System.out.println("b1 << 1 => " + (b1 << 1));
        System.out.println("b1 >> 1 => " + (b1 >> 1));
        System.out.println("b1 >>> 1 => " + (b1 >>> 1));

        System.out.println("=====================================");

        // 负数
        int b3 = 0b1111_1111_1111_1111_1111_1111_1111_0110;
        System.out.println("b3: " + b3);
        System.out.println("b3 << 1 => " + Integer.toBinaryString(b3 << 1));
        System.out.println("b3 << 1 => " + (b3 << 1));
        System.out.println("b3 >> 1 => " + (b3 >> 1));
        System.out.println("b3 >>> 1 => " + (b3 >>> 1));

        System.out.println("==================");

        int b4 = 0b1111_1111_1111_1111_1111_1111_1011_1010;
        System.out.println("b4: " + b4);
        System.out.println("b4 << 1 => " + (b4 << 1));
        System.out.println("b4 >> 1 => " + (b4 >> 1));
        System.out.println("b4 >>> 1 => " + (b4 >>> 1));

    }
}
