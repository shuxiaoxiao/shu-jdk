package com.shuframework.designpattern.factory;

/**
 * @author shuheng
 */
public class FactoryClient {
    public static void main(String[] args) {
        CarFactoryAbstractEnum.BENCHI.create();

        CarFactoryEnum.BENCHI.create();
    }
}
