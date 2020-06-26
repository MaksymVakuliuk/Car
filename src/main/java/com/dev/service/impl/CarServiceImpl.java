package com.dev.service.impl;

import com.dev.model.Car;
import com.dev.model.CarDoor;
import com.dev.model.CarWheel;
import com.dev.service.CarService;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public double changeCurrentSpeed(Car car, double newSpeed) {
        car.setCurrentSpeed(newSpeed);
        return car.getCurrentSpeed();
    }

    @Override
    public int putPersonInCar(Car car) {
        car.setCurrentNumberOfPassengers(car.getCurrentNumberOfPassengers() + 1);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public int evictPersonFromCar(Car car) {
        car.setCurrentNumberOfPassengers(car.getCurrentNumberOfPassengers() - 1);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public int evictAllPersonsFromCar(Car car) {
        car.setCurrentNumberOfPassengers(0);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public CarDoor getCarDoorByIndex(Car car, int index) {
        return car.getCarDoors().get(index);
    }

    @Override
    public CarWheel getCarWheelByIndex(Car car, int index) {
        return car.getCarWheels().get(index);
    }

    @Override
    public int removeAllWheelsFromCar(Car car) {
        car.getCarWheels().clear();
        return car.getCarWheels().size();
    }

    @Override
    public List<CarWheel> installWheelsOnCar(Car car, int numberOfNewCarWheels) {
        List<CarWheel> carWheels = car.getCarWheels();
        for (int i = 0; i < numberOfNewCarWheels; i++) {
            carWheels.add(new CarWheel());
        }
        return carWheels;
    }

    @Override
    public double calculateMaxSpeed(Car car) {
        if (car.getCurrentNumberOfPassengers() == 0 || car.getCarWheels().size() == 0) {
            return 0;
        }
        double minTyreWheelCondition = car.getCarWheels()
                .stream()
                .map(CarWheel::getTyreWearCondition)
                .mapToDouble(Double::doubleValue)
                .min()
                .getAsDouble();
        return car.getMaxSpeed() * minTyreWheelCondition;
    }

    @Override
    public String printToConsole(Car car) {
        String output = car.toString();
        System.out.println(output);
        return output;
    }
}
