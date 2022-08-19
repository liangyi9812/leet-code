package com.edison.designpartten.simplefactory;

/**
 * 简单工厂
 *
 * @author LiangYi
 * @date 2022-8-20
 */
public class ProductSimpleFactory {

    public static AbstractProduct makeProduct(ProductTypeEnum type) {
        switch (type) {
            case CELL_PHONE:
                return new CellPhone();
            case COMPUTER:
                return new Computer();
            default:
                throw new IllegalArgumentException("can't find this type of product, type: " + type);
        }
    }

    public static AbstractProduct makeProductByClass(Class<? extends AbstractProduct> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
