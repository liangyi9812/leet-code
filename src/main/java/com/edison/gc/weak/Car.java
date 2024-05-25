package com.edison.gc.weak;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liangyi
 * @date 2024/3/3
 */
@Setter
@Getter
public class Car {
    private double price;
    private String colour;

    public Car(double price, String colour){
        this.price = price;
        this.colour = colour;
    }

    public String toString(){
        return colour +"car costs $"+price;
    }
}
