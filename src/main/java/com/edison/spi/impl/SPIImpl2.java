package com.edison.spi.impl;

import com.edison.spi.MySPIServiceInterface;

/**
 * @author liangyi
 * @date 2024/3/22
 */
public class SPIImpl2 implements MySPIServiceInterface {
    @Override
    public void doSomething(String content) {

        System.out.println("SPIImpl2 do: " + content);

    }
}
