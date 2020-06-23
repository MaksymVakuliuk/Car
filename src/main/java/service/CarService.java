package service;

import java.util.List;
import model.Car;
import model.CarDoor;
import model.CarWheel;

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
