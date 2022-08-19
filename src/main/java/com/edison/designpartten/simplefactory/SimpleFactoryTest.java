package com.edison.designpartten.simplefactory;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        AbstractProduct cellPhone = ProductSimpleFactory.makeProduct(ProductTypeEnum.CELL_PHONE);
        System.out.println("get product, name: " + cellPhone.getProductName());

        AbstractProduct computer = ProductSimpleFactory.makeProductByClass(Computer.class);
        System.out.println("get product by class, name: " + computer.getProductName());

        System.out.println(computer instanceof CellPhone); // false
        System.out.println(computer instanceof Computer); // true
        System.out.println(computer instanceof AbstractProduct); // true

        System.out.println(AbstractProduct.class.isAssignableFrom(Computer.class)); // true
        System.out.println(AbstractProduct.class.isAssignableFrom(CellPhone.class)); // true
        System.out.println(AbstractProduct.class.isAssignableFrom(AbstractProduct.class)); // true
        System.out.println(CellPhone.class.isAssignableFrom(CellPhone.class)); // true
    }

}
