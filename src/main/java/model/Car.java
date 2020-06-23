package model;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Car {
    private final LocalDate dateOfManufacture = LocalDate.now();
    private String typOfEngine;
    private double maxSpeed;
    private double zeroHundredTimes;
    private int seatingCapacity;
    private int currentNumberOfPassengers;
    private double currentSpeed;
    private List<CarWheel> carWheels;
    private List<CarDoor> carDoors;
}
