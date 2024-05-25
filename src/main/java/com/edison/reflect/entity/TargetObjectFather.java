package com.edison.reflect.entity;

/**
 * @author liangyi
 * @date 2024/2/20
 */
public class TargetObjectFather {
    private String fatherPrivateValue;
    public String fatherPublicValue;

    public TargetObjectFather() {
        fatherPrivateValue = "father";
        fatherPublicValue = "public father";
    }

    public void publicFatherMethod(String s) {
        System.out.println("(From Father) I love " + s);
    }

    private void privateFatherMethod() {
        System.out.println("value is " + fatherPrivateValue);
    }

    public static void main(String[] args) {
        TargetObjectFather father = new TargetObjectFather();
        System.out.println(father.fatherPrivateValue);
    }
}
