package service;

import model.CarDoor;
import org.junit.Before;
import org.junit.Test;
import service.impl.CarDoorServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarDoorServiceTest {
    private final CarDoorService carDoorService = new CarDoorServiceImpl();;
    private CarDoor carDoor;
    
    @Before
    public void setUp() throws Exception {
        carDoor = new CarDoor();
    }

    @Test
    public void openDoor() {
        assertTrue(carDoorService.openDoor(carDoor));
    }

    @Test
    public void closeDoor() {
        assertFalse(carDoorService.closeDoor(carDoor));
        carDoor.setOpenDoor(false);
        assertFalse(carDoorService.closeDoor(carDoor));
    }

    @Test
    public void changeDoorStatus() {
        carDoor.setOpenDoor(false);
        assertTrue(carDoorService.changeDoorStatus(carDoor));
        carDoor.setOpenDoor(true);
        assertFalse(carDoorService.changeDoorStatus(carDoor));
    }

    @Test
    public void openWindow() {
        assertTrue(carDoorService.openWindow(carDoor));
        carDoor.setOpenWindow(true);
        assertTrue(carDoorService.openWindow(carDoor));
    }

    @Test
    public void closeWindow() {
        assertFalse(carDoorService.closeWindow(carDoor));
        carDoor.setOpenWindow(false);
        assertFalse(carDoorService.closeWindow(carDoor));
    }

    @Test
    public void changeWindowStatus() {
        carDoor.setOpenWindow(false);
        assertTrue(carDoorService.changeWindowStatus(carDoor));
        carDoor.setOpenWindow(true);
        assertFalse(carDoorService.changeWindowStatus(carDoor));
    }

    @Test
    public void printToConsole() {
        String expected1 = "CarDoor(isOpenDoor=false, isOpenWindow=false)";
        String expected2 = "CarDoor(isOpenDoor=true, isOpenWindow=false)";
        String expected3 = "CarDoor(isOpenDoor=false, isOpenWindow=true)";
        carDoor.setOpenWindow(false);
        carDoor.setOpenWindow(false);
        assertEquals(expected1, carDoorService.printToConsole(carDoor));
        carDoor.setOpenDoor(true);
        assertEquals(expected2, carDoorService.printToConsole(carDoor));
        carDoor.setOpenDoor(false);
        carDoor.setOpenWindow(true);
        assertEquals(expected3, carDoorService.printToConsole(carDoor));
    }
}
