package service.impl;

import model.CarDoor;
import service.CarDoorService;

public class CarDoorServiceImpl implements CarDoorService {
    @Override
    public boolean openDoor(CarDoor carDoor) {
        carDoor.setOpenDoor(true);
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean closeDoor(CarDoor carDoor) {
        carDoor.setOpenDoor(false);
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean changeDoorStatus(CarDoor carDoor) {
        carDoor.setOpenDoor(!carDoor.isOpenDoor());
        return carDoor.isOpenDoor();
    }

    @Override
    public boolean openWindow(CarDoor carDoor) {
        carDoor.setOpenWindow(true);
        return carDoor.isOpenWindow();
    }

    @Override
    public boolean closeWindow(CarDoor carDoor) {
        carDoor.setOpenWindow(false);
        return carDoor.isOpenWindow();
    }

    @Override
    public boolean changeWindowStatus(CarDoor carDoor) {
        carDoor.setOpenWindow(!carDoor.isOpenWindow());
        return carDoor.isOpenWindow();
    }

    @Override
    public String printToConsole(CarDoor carDoor) {
        return carDoor.toString();
    }
}
