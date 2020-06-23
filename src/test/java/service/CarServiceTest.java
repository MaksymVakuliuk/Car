package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Car;
import model.CarDoor;
import model.CarWheel;
import org.junit.Before;
import org.junit.Test;
import service.impl.CarDoorServiceImpl;
import service.impl.CarServiceImpl;
import service.impl.CarWheelServiceImpl;
import static org.junit.Assert.assertEquals;

public class CarServiceTest {
    private static final double DELTA = 0.0001;
    private final CarDoorService carDoorService = new CarDoorServiceImpl();
    private final CarWheelService carWheelService = new CarWheelServiceImpl();
    private final CarService carService = new CarServiceImpl();
    private List<CarWheel> defaultCarWheels;
    private List<CarDoor> defaultCarDoors;
    private Car car;

    @Before
    public void setUp() throws Exception {
        defaultCarWheels = Stream.generate(CarWheel::new).limit(4).collect(Collectors.toList());
        defaultCarDoors = Stream.generate(CarDoor::new).limit(4).collect(Collectors.toList());
        car = Car.builder()
                .typOfEngine("gas")
                .maxSpeed(130)
                .zeroHundredTimes(6)
                .seatingCapacity(4)
                .currentNumberOfPassengers(1)
                .currentSpeed(50)
                .carWheels(defaultCarWheels)
                .carDoors(defaultCarDoors)
                .build();
    }

    @Test
    public void changeCurrentSpeed() {
        assertEquals(60, carService.changeCurrentSpeed(car, 60), DELTA);
    }

    @Test
    public void putPersonInCar() {
        assertEquals(2, carService.putPersonInCar(car));
        assertEquals(3, carService.putPersonInCar(car));
    }

    @Test
    public void evictPersonFromCar() {
        assertEquals(0, carService.evictPersonFromCar(car));
        car.setCurrentNumberOfPassengers(4);
        assertEquals(3, carService.evictPersonFromCar(car));
    }

    @Test
    public void evictAllPersonsFromCar() {
        car.setCurrentNumberOfPassengers(4);
        assertEquals(0, carService.evictAllPersonsFromCar(car));
    }

    @Test
    public void getCarDoorByIndex() {
        CarDoor carDoor = new CarDoor();
        carDoorService.openWindow(carDoor);
        car.getCarDoors().get(2).setOpenWindow(true);
        assertEquals(carDoor, carService.getCarDoorByIndex(car, 2));
    }

    @Test
    public void getCarWheelByIndex() {
        CarWheel carWheel = new CarWheel();
        carWheel.setTyreWearCondition(0.73);
        car.getCarWheels().get(2).setTyreWearCondition(0.73);
        assertEquals(carWheel, carService.getCarWheelByIndex(car,2));
    }

    @Test
    public void removeAllWheelsFromCar() {
        assertEquals(0, carService.removeAllWheelsFromCar(car));
    }

    @Test
    public void installWheelsOnCar() {
        car.getCarWheels().addAll(List.of(new CarWheel(), new CarWheel()));
        assertEquals(car.getCarWheels(), carService.installWheelsOnCar(car, 2));
    }

    @Test
    public void calculateMaxSpeed() {
        assertEquals(130, carService.calculateMaxSpeed(car), DELTA);
        car.getCarWheels().get(3).setTyreWearCondition(0.62);
        assertEquals(130*0.62, carService.calculateMaxSpeed(car), DELTA);
        carService.evictAllPersonsFromCar(car);
        assertEquals(0, carService.calculateMaxSpeed(car), DELTA);
        carService.putPersonInCar(car);
        carService.removeAllWheelsFromCar(car);
        assertEquals(0, carService.calculateMaxSpeed(car), DELTA);
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
        assertEquals(expected, carService.printToConsole(car));
    }
}
