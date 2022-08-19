package com.edison.outinclass;

import lombok.Data;

/**
 * @author LiangYi
 * @date 2022-6-21
 */
public class Father implements Cloneable{

    private Son son;
    public static String fatherName;
    private String normalFatherName;

    public void fatherSay() {
        System.out.println(son.sonName);
    }

    public void sayFatherName() {
        System.out.println(fatherName);
    }

    @Override
    public Father clone() {
        try {
            return (Father) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Data
    private class Son {

        private String sonName;

        public void sonSay() {
            System.out.println(fatherName);
            //System.out.println(normalFatherName);
        }

        public void sonSay(int num, String s) {

        }

        public void sonSay(String s, int num) {

        }

    }

}
