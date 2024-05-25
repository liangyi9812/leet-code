package com.edison.reflect.entity;

import java.util.NoSuchElementException;

/**
 * @author liangyi
 * @date 2024/2/20
 */
public class TargetObject extends TargetObjectFather {

    private String sonPrivateValue;

    public String sonPublicValue;

    public TargetObject() {
        sonPrivateValue = "son";
        sonPublicValue = "public son";
    }

    public void publicSonMethod(String s) {
        if (s.equals("hah")) {
            throw new NoSuchElementException("not ok~");
        }
        System.out.println("(From Son) I love " + s);
    }

    private void privateSonMethod() {
        System.out.println("value is " + sonPrivateValue);
    }

    class NestedTargetClass {
        void print() {
            System.out.println(sonPrivateValue);
        }
    }
}
