package com.edison.thread.happensbefore;

/**
 * @author liangyi
 * @date 2024/2/27
 */
public class ReOrderDemo {

    int x = 0;
    boolean flag = false;

    public void writer() {
        x = 42; //1
        flag = true; //2
    }

    public void reader () {
        if (flag) { //3
//            System.out.println("in if, x: " + x); //4
            if (x == 0) {
                System.out.println("in if, catch reOrder x ==> " + x);
            }
        }

        class MethodClass {
            private final String name;

            public MethodClass(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "MethodClass{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
        MethodClass methodClass = new MethodClass("liangyi");
        System.out.println(methodClass);

    }

    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("reOrder dead");
    }
}
