package service;

import model.CarDoor;
import org.junit.Before;
import org.junit.Test;
import service.CarDoorService;
import service.impl.CarDoorServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarDoorServiceTest {
    private CarDoorService carDoorService;

    @Before
    public void setUp() throws Exception {
        carDoorService = new CarDoorServiceImpl(new CarDoor());
    }

    @Test
    public void openDoor() {
        assertTrue(carDoorService.openDoor());
    }

    @Test
    public void closeDoor() {
        assertFalse(carDoorService.closeDoor());
        carDoorService.getCarDoor().setOpenDoor(false);
        assertFalse(carDoorService.closeDoor());
    }

    @Test
    public void changeDoorStatus() {
        carDoorService.getCarDoor().setOpenDoor(false);
        assertTrue(carDoorService.changeDoorStatus());
        carDoorService.getCarDoor().setOpenDoor(true);
        assertFalse(carDoorService.changeDoorStatus());
    }

    @Test
    public void openWindow() {
        assertTrue(carDoorService.openWindow());
        carDoorService.getCarDoor().setOpenWindow(true);
        assertTrue(carDoorService.openWindow());
    }

    @Test
    public void closeWindow() {
        assertFalse(carDoorService.closeWindow());
        carDoorService.getCarDoor().setOpenWindow(false);
        assertFalse(carDoorService.closeWindow());
    }

    @Test
    public void changeWindowStatus() {
        carDoorService.getCarDoor().setOpenWindow(false);
        assertTrue(carDoorService.changeWindowStatus());
        carDoorService.getCarDoor().setOpenWindow(true);
        assertFalse(carDoorService.changeWindowStatus());
    }

    @Test
    public void printToConsole() {
        String expected1 = "CarDoor(isOpenDoor=false, isOpenWindow=false)";
        String expected2 = "CarDoor(isOpenDoor=true, isOpenWindow=false)";
        String expected3 = "CarDoor(isOpenDoor=false, isOpenWindow=true)";
        carDoorService.getCarDoor().setOpenWindow(false);
        carDoorService.getCarDoor().setOpenWindow(false);
        assertEquals(expected1, carDoorService.printToConsole());
        carDoorService.getCarDoor().setOpenDoor(true);
        assertEquals(expected2, carDoorService.printToConsole());
        carDoorService.getCarDoor().setOpenDoor(false);
        carDoorService.getCarDoor().setOpenWindow(true);
        assertEquals(expected3, carDoorService.printToConsole());
    }
}
