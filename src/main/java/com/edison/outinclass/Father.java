package com.edison.outinclass;

import lombok.Data;

/**
 * @author LiangYi
 * @date 2022-6-21
 */
public class Father {

    private Son son;
    private static String fatherName;
    private String normalFatherName;

    public void fatherSay() {
        System.out.println(son.sonName);
    }

    @Data
    private class Son {

        private String sonName;

        public void sonSay() {
            System.out.println(fatherName);
            //System.out.println(normalFatherName);
        }

    }

}
