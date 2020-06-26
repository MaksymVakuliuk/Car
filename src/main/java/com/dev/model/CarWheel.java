package com.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "car_wheel")
public class CarWheel {
    private static final double MIN_TYRE_WEAR_CONDITION = 0.0;
    private static final double MAX_TYRE_WEAR_CONDITION = 1.0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double tyreWearCondition;

    public CarWheel() {
        this.tyreWearCondition = MAX_TYRE_WEAR_CONDITION;
    }
}
