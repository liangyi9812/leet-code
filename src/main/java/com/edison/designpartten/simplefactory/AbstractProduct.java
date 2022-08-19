package com.edison.designpartten.simplefactory;

import lombok.Data;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
@Data
public abstract class AbstractProduct {

    private String productName;

    public AbstractProduct(String productName) {
        this.productName = productName;
    }

}
