package service.impl;

import java.util.List;
import model.Car;
import model.CarDoor;
import model.CarWheel;
import service.CarService;

public class CarServiceImpl implements CarService {
    private final Car car;

    public CarServiceImpl(Car car) {
        this.car = car;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public double changeCurrentSpeed(double newSpeed) {
        car.setCurrentSpeed(newSpeed);
        return car.getCurrentSpeed();
    }

    @Override
    public int putPersonInCar() {
        car.setCurrentNumberOfPassengers(car.getCurrentNumberOfPassengers() + 1);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public int evictPersonFromCar() {
        car.setCurrentNumberOfPassengers(car.getCurrentNumberOfPassengers() - 1);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public int evictAllPersonsFromCar() {
        car.setCurrentNumberOfPassengers(0);
        return car.getCurrentNumberOfPassengers();
    }

    @Override
    public CarDoor getCarDoorByIndex(int index) {
        return car.getCarDoors().get(index);
    }

    @Override
    public CarWheel getCarWheelByIndex(int index) {
        return car.getCarWheels().get(index);
    }

    @Override
    public int removeAllWheelsFromCar() {
        car.getCarWheels().clear();
        return car.getCarWheels().size();
    }

    @Override
    public List<CarWheel> installWheelsOnCar(int numberOfNewCarWheels) {
        List<CarWheel> carWheels = car.getCarWheels();
        for (int i = 0; i < numberOfNewCarWheels; i++) {
            carWheels.add(new CarWheel());
        }
        return carWheels;
    }

    @Override
    public double calculateMaxSpeed() {
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
    public String printToConsole() {
        String output = car.toString();
        System.out.println(output);
        return output;
    }
}
