package com.edison.tools;

import com.edison.exception.MyCheckedException;
import lombok.SneakyThrows;

import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/2
 */
public class Tool {

    public static <T> T print(T object) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(Optional.ofNullable(object).map(Object::toString).orElse("null" ))
                .toString();
        System.out.println(result);
        return object;
    }

    @SneakyThrows
    public static void sleepSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public static void causeRuntimeException() {
        throw new RuntimeException("!!!cause exception!!!");
    }

    public static void causeCheckedException() throws MyCheckedException {
        throw new MyCheckedException("!!!cause checked exception!!!");
    }


}
