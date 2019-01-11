package com.shuframework.designpattern.factory;

import com.shuframework.designpattern.testmodel.BenchiCar;
import com.shuframework.designpattern.testmodel.Car;
import com.shuframework.designpattern.testmodel.DazhongCar;

/**
 * @author shuheng
 */
public enum CarFactoryAbstractEnum {

    DAZHONG {
        @Override
        public Car create() {
            return new DazhongCar();
        }
    }, BENCHI{
        @Override
        public Car create() {
            return new BenchiCar();
        }
    };

    public abstract Car create();

}
