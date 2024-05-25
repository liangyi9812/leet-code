package com.edison;

/**
 * @author LiangYi
 * @date 2022-7-4
 */
public class Main {

    public static void main(String[] args) {
        final int[] value = {1, 2, 3};
    }

}

class Computer {
    private String brand;

    public IBM getBrand() throws ComputerSonException {
        return new IBM();
    }

}

class IBM extends Computer {
    private String brand;

    @Override
    public IBM getBrand() throws ComputerSonSonException {
        return this;
    }

}

class ComputerFotherException extends Exception {
    public ComputerFotherException(String message) {
        super(message);
    }
}

class ComputerSonException extends ComputerFotherException {
    public ComputerSonException(String message) {
        super(message);
    }
}

class ComputerSonSonException extends ComputerSonException {
    public ComputerSonSonException(String message) {
        super(message);
    }
}
