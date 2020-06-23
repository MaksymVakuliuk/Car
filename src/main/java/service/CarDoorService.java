package service;

import model.CarDoor;

public interface CarDoorService {
    public CarDoor getCarDoor();

    public boolean openDoor();

    public boolean closeDoor();

    public boolean changeDoorStatus();

    public boolean openWindow();

    public boolean closeWindow();

    public boolean changeWindowStatus();

    public String printToConsole();
}
