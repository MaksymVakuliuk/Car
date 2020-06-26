package com.dev.service.impl;

import com.dev.model.CarWheel;
import com.dev.service.CarWheelService;

public class CarWheelServiceImpl implements CarWheelService {
    @Override
    public double changeToNew(CarWheel carWheel) {
        carWheel = new CarWheel();
        return carWheel.getTyreWearCondition();
    }

    @Override
    public double eraseWheel(CarWheel carWheel, double delta) {
        if (delta / 100 > carWheel.getTyreWearCondition()) {
            throw new RuntimeException("Error wheel not have enough expected life ");
        }
        carWheel.setTyreWearCondition(carWheel.getTyreWearCondition() - (delta / 100));
        return carWheel.getTyreWearCondition();
    }

    @Override
    public String printToConsole(CarWheel carWheel) {
        String output = carWheel.toString();;
        System.out.println(output);
        return output;
    }
}
