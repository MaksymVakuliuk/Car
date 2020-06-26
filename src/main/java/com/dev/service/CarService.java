package com.dev.service;

import com.dev.model.Car;
import com.dev.model.CarDoor;
import com.dev.model.CarWheel;
import java.util.List;

public interface CarService {
    double changeCurrentSpeed(Car car, double newSpeed);

    int putPersonInCar(Car car);

    int evictPersonFromCar(Car car);

    int evictAllPersonsFromCar(Car car);

    CarDoor getCarDoorByIndex(Car car, int index);

    CarWheel getCarWheelByIndex(Car car, int index);

    int removeAllWheelsFromCar(Car car);

    List<CarWheel> installWheelsOnCar(Car car, int numberOfNewCarWheels);

    double calculateMaxSpeed(Car car);

    String printToConsole(Car car);
}
