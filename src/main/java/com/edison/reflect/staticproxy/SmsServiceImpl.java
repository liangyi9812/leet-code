package com.edison.reflect.staticproxy;

/**
 * @author liangyi
 * @date 2024/2/20
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        return "send message: " + message;
    }
}
