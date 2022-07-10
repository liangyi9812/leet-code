package com.edison.leetcode;

import java.util.*;

/**
 * @author LiangYi
 * @date 2022-7-7
 */
public class LeetCode648 {
    public static void main(String[] args) {
        String sentence = "the cattle was rattled by the battery";
        List<String> dic = Arrays.asList("cat", "bat", "rat");
        System.out.println(replaceWords2(dic, sentence));
    }


    /**
     * 超时
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> res = new ArrayList<>();
        String[] strings = sentence.split("\\s+");
        dictionary.sort(Comparator.comparingInt(String::length));
        out:
        for (String str : strings) {
            for (String s : dictionary) {
                if (s.length() > str.length()) {
                    res.add(str);
                    continue out;
                }
                if (str.startsWith(s)) {
                    res.add(s);
                    continue out;
                }
            }
            res.add(str);
        }
        return String.join(" ", res);
    }

    public static String replaceWords2(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String str : dictionary) {
            root.insertWord(str);
        }
        String[] split = sentence.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            split[i] = root.checkWord(split[i]);
        }
        return String.join(" ", split);
    }

    /**
     * 字典树
     */
    static class TrieNode {

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public TrieNode[] children;
        public boolean isWord;

        public void insertWord(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = this;
            for (char ch : chars) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }

        public String checkWord(String str) {
            char[] chars = str.toCharArray();
            TrieNode cur = this;
            int depth = 1;
            for (char ch : chars) {
                TrieNode[] trieChildren = cur.children;
                if (trieChildren[ch - 'a'] == null) {
                    return str;
                } else {
                    cur = trieChildren[ch - 'a'];
                    if (cur.isWord) {
                        return str.substring(0, depth);
                    }
                }
                depth++;
            }
            return str;
        }
    }
}
