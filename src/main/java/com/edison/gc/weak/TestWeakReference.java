package com.edison.gc.weak;

import lombok.SneakyThrows;

import java.lang.ref.WeakReference;

/**
 * @author liangyi
 * @date 2024/3/3
 */
public class TestWeakReference {

    @SneakyThrows
    public static void main(String[] args) {

        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);

        int i = 0;

        while (true) {
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
