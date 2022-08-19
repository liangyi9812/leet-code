package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    /**
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            int slow = 0;
            StringBuilder builder = new StringBuilder();
            for (int m = 0; m < res.length(); m++) {
                if (res.charAt(m) == res.charAt(slow)) {
                    continue;
                }
                int count = m - slow;
                char word = res.charAt(slow);
                builder.append(count).append(word);
                slow = m;
            }
            // last one
            int count = res.length() - slow;
            char word = res.charAt(slow);
            builder.append(count).append(word);
            res = builder.toString();
        }
        return res;
    }

}
