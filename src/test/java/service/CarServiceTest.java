package service;

import model.Car;
import model.CarDoor;
import model.CarWheel;
import org.junit.Before;
import org.junit.Test;
import service.impl.CarDoorServiceImpl;
import service.impl.CarServiceImpl;
import service.impl.CarWheelServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CarServiceTest {
    private static final double DELTA = 0.0001;
    private List<CarWheel> defaultCarWheels;
    private List<CarDoor> defaultCarDoors;
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        defaultCarWheels = Stream.generate(CarWheel::new).limit(4).collect(Collectors.toList());
        defaultCarDoors = Stream.generate(CarDoor::new).limit(4).collect(Collectors.toList());
        carService = new CarServiceImpl(Car.builder()
                .typOfEngine("gas")
                .maxSpeed(130)
                .zeroHundredTimes(6)
                .seatingCapacity(4)
                .currentNumberOfPassengers(1)
                .currentSpeed(50)
                .carWheels(defaultCarWheels)
                .carDoors(defaultCarDoors)
                .build());
    }

    @Test
    public void changeCurrentSpeed() {
        assertEquals(60, carService.changeCurrentSpeed(60), DELTA);
    }

    @Test
    public void putPersonInCar() {
        assertEquals(2, carService.putPersonInCar());
        assertEquals(3, carService.putPersonInCar());
    }

    @Test
    public void evictPersonFromCar() {
        assertEquals(0, carService.evictPersonFromCar());
        carService.getCar().setCurrentNumberOfPassengers(4);
        assertEquals(3, carService.evictPersonFromCar());
    }

    @Test
    public void evictAllPersonsFromCar() {
        carService.getCar().setCurrentNumberOfPassengers(4);
        assertEquals(0, carService.evictAllPersonsFromCar());
    }

    @Test
    public void getCarDoorByIndex() {
        CarDoorService carDoorService = new CarDoorServiceImpl(new CarDoor());
        carDoorService.openWindow();
        carService.getCar().getCarDoors().get(2).setOpenWindow(true);
        assertEquals(carDoorService.getCarDoor(), carService.getCarDoorByIndex(2));
    }

    @Test
    public void getCarWheelByIndex() {
        CarWheelService carWheelService = new CarWheelServiceImpl(new CarWheel());
        carWheelService.getCarWheel().setTyreWearCondition(0.73);
        carService.getCar().getCarWheels().get(2).setTyreWearCondition(0.73);
        assertEquals(carWheelService.getCarWheel(), carService.getCarWheelByIndex(2));
    }

    @Test
    public void removeAllWheelsFromCar() {
        assertEquals(0, carService.removeAllWheelsFromCar());
    }

    @Test
    public void installWheelsOnCar() {
        carService.getCar().getCarWheels().addAll(List.of(new CarWheel(), new CarWheel()));
        assertEquals(carService.getCar().getCarWheels(), carService.installWheelsOnCar(2));
    }

    @Test
    public void calculateMaxSpeed() {
        assertEquals(130, carService.calculateMaxSpeed(), DELTA);
        carService.getCar().getCarWheels().get(3).setTyreWearCondition(0.62);
        assertEquals(130*0.62, carService.calculateMaxSpeed(), DELTA);
        carService.evictAllPersonsFromCar();
        assertEquals(0, carService.calculateMaxSpeed(), DELTA);
        carService.putPersonInCar();
        carService.removeAllWheelsFromCar();
        assertEquals(0, carService.calculateMaxSpeed(), DELTA);
    }

    @Test
    public void printToConsole() {
        String expected = "Car(dateOfManufacture=2020-06-23, typOfEngine=gas,"
                + " maxSpeed=130.0, zeroHundredTimes=6.0,"
                + " seatingCapacity=4, currentNumberOfPassengers=1, currentSpeed=50.0,"
                + " carWheels="
                + "[CarWheel(tyreWearCondition=1.0), CarWheel(tyreWearCondition=1.0), "
                + "CarWheel(tyreWearCondition=1.0), CarWheel(tyreWearCondition=1.0)],"
                + " carDoors="
                + "[CarDoor(isOpenDoor=false, isOpenWindow=false),"
                + " CarDoor(isOpenDoor=false, isOpenWindow=false),"
                + " CarDoor(isOpenDoor=false, isOpenWindow=false),"
                + " CarDoor(isOpenDoor=false, isOpenWindow=false)])";
        assertEquals(expected, carService.printToConsole());
    }
}