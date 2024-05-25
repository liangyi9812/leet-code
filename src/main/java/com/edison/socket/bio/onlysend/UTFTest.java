package com.edison.socket.bio.onlysend;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author liangyi
 * @date 2024/3/15
 */
public class UTFTest {

    public static void main(String[] args) {

        String str = "梁毅";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

    }

}
