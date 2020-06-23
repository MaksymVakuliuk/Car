package service.impl;

import model.CarDoor;
import service.CarDoorService;

public class CarDoorServiceImpl implements CarDoorService {
    private final CarDoor carDoor;

    public CarDoorServiceImpl(CarDoor carDoor) {
        this.carDoor = carDoor;
    }

    @Override
    public CarDoor getCarDoor() {
        return carDoor;
    }

    @Override
    public boolean openDoor() {
        carDoor.setOpenDoor(true);
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean closeDoor() {
        carDoor.setOpenDoor(false);
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean changeDoorStatus() {
        carDoor.setOpenDoor(!carDoor.isOpenDoor());
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean openWindow() {
        carDoor.setOpenWindow(true);
        return carDoor.isOpenWindow();
    }

    @Override
    public boolean closeWindow() {
        carDoor.setOpenWindow(false);
        return carDoor.isOpenWindow();
    }

    @Override
    public boolean changeWindowStatus() {
        carDoor.setOpenWindow(!carDoor.isOpenWindow());
        return carDoor.isOpenWindow();
    }

    @Override
    public String printToConsole() {
        return carDoor.toString();
    }
}
