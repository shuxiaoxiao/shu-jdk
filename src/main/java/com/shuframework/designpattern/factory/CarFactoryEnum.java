package com.shuframework.designpattern.factory;

import com.shuframework.designpattern.testmodel.BenchiCar;
import com.shuframework.designpattern.testmodel.Car;
import com.shuframework.designpattern.testmodel.DazhongCar;

/**
 * @author shuheng
 */
public enum CarFactoryEnum {

    DAZHONG, BENCHI;

    public Car create() {
        switch (this){
            case BENCHI:
                return new BenchiCar();
            case DAZHONG:
                return new DazhongCar();
        }

        return null;
    }

}
