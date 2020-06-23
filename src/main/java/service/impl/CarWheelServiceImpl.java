package service.impl;

import model.CarWheel;
import service.CarWheelService;

public class CarWheelServiceImpl implements CarWheelService {
    private CarWheel carWheel;

    public CarWheelServiceImpl(CarWheel carWheel) {
        this.carWheel = carWheel;
    }

    @Override
    public CarWheel getCarWheel() {
        return carWheel;
    }

    @Override
    public double changeToNew() {
        carWheel = new CarWheel();
        return carWheel.getTyreWearCondition();
    }

    @Override
    public double eraseWheel(double delta) {
        if (delta / 100 > carWheel.getTyreWearCondition()) {
            throw new RuntimeException("Error wheel not have enough expected life ");
        }
        carWheel.setTyreWearCondition(carWheel.getTyreWearCondition() - (delta / 100));
        return carWheel.getTyreWearCondition();
    }

    @Override
    public String printToConsole() {
        String output = carWheel.toString();;
        System.out.println(output);
        return output;
    }
}
