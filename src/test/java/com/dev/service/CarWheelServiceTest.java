package com.dev.service;

import com.dev.model.CarWheel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.dev.service.impl.CarWheelServiceImpl;

public class CarWheelServiceTest {
    private static final double DELTA = 0.0001;
    private final CarWheelService carWheelService = new CarWheelServiceImpl();
    private CarWheel carWheel;

    @Before
    public void setUp() throws Exception {
        carWheel = new CarWheel();
    }

    @Test
    public void changeToNew() {
        carWheel.setTyreWearCondition(0.74);
        Assert.assertEquals(1.0, carWheelService.changeToNew(carWheel), DELTA);
    }

    @Test
    public void eraseWheel() {
        Assert.assertEquals(0.80, carWheelService.eraseWheel(carWheel,20), DELTA);
    }

    @Test
    public void printToConsole() {
        String expected1 = "CarWheel(tyreWearCondition=1.0)";
        String expected2 = "CarWheel(tyreWearCondition=0.8)";
        Assert.assertEquals(expected1, carWheelService.printToConsole(carWheel));
        carWheelService.eraseWheel(carWheel, 20);
        Assert.assertEquals(expected2, carWheelService.printToConsole(carWheel));
    }
}
