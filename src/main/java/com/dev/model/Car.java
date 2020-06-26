package com.dev.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final LocalDate dateOfManufacture = LocalDate.now();
    private String typOfEngine;
    private double maxSpeed;
    private double zeroHundredTimes;
    private int seatingCapacity;
    private int currentNumberOfPassengers;
    private double currentSpeed;
    @OneToMany
    private List<CarWheel> carWheels;
    @OneToMany
    private List<CarDoor> carDoors;
}
