package service;

import model.CarWheel;
import org.junit.Before;
import org.junit.Test;
import service.impl.CarWheelServiceImpl;

import static org.junit.Assert.*;

public class CarWheelServiceTest {
    private static final double DELTA = 0.0001;
    private CarWheelService carWheelService;

    @Before
    public void setUp() throws Exception {
        carWheelService = new CarWheelServiceImpl(new CarWheel());
    }

    @Test
    public void changeToNew() {
        carWheelService.getCarWheel().setTyreWearCondition(0.74);
        assertEquals(1.0, carWheelService.changeToNew(), DELTA);
    }

    @Test
    public void eraseWheel() {
        assertEquals(0.80, carWheelService.eraseWheel(20), DELTA);
    }

    @Test
    public void printToConsole() {
        String expected1 = "CarWheel(tyreWearCondition=1.0)";
        String expected2 = "CarWheel(tyreWearCondition=0.8)";
        assertEquals(expected1, carWheelService.printToConsole());
        carWheelService.eraseWheel(20);
        assertEquals(expected2, carWheelService.printToConsole());
    }
}
