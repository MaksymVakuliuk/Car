package service;

import model.CarDoor;

public interface CarDoorService {
    boolean openDoor(CarDoor carDoor);

    boolean closeDoor(CarDoor carDoor);

    boolean changeDoorStatus(CarDoor carDoor);

    boolean openWindow(CarDoor carDoor);

    boolean closeWindow(CarDoor carDoor);

    boolean changeWindowStatus(CarDoor carDoor);

    String printToConsole(CarDoor carDoor);
}
