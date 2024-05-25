package com.edison.spi;

import java.util.ServiceLoader;

/**
 * @author liangyi
 * @date 2024/3/22
 */
public class SPITest {

    public static void main(String[] args) {

        String content = "hell no!";

        ServiceLoader<MySPIServiceInterface> load = ServiceLoader.load(MySPIServiceInterface.class);
        for (MySPIServiceInterface service : load) {
            service.doSomething(content);
        }

    }

}
