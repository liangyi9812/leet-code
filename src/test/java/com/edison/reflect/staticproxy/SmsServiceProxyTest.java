package com.edison.reflect.staticproxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liangyi
 * @date 2024/2/20
 */
class SmsServiceProxyTest {

    @Test
    void send() {
        SmsService smsService = new SmsServiceImpl();
        SmsServiceProxy smsServiceProxy = new SmsServiceProxy(smsService);
        String result = smsServiceProxy.send("hello");
        assertEquals("send message: hello", result);
    }
}
