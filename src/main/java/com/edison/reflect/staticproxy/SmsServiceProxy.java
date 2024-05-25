package com.edison.reflect.staticproxy;

/**
 * @author liangyi
 * @date 2024/2/20
 */
public class SmsServiceProxy implements SmsService{

    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("before send");
        String sendResult = smsService.send(message);
        System.out.println("after send");
        return sendResult;
    }

}
