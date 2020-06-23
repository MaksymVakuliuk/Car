package service;

import java.util.List;
import model.Car;
import model.CarDoor;
import model.CarWheel;

public interface CarService {
    Car getCar();

    double changeCurrentSpeed(double newSpeed);

    int putPersonInCar();

    int evictPersonFromCar();

    int evictAllPersonsFromCar();

    CarDoor getCarDoorByIndex(int index);

    CarWheel getCarWheelByIndex(int index);

    int removeAllWheelsFromCar();

    List<CarWheel> installWheelsOnCar(int numberOfNewCarWheels);

    double calculateMaxSpeed();

    String printToConsole();
}
