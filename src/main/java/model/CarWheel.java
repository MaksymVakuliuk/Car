package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CarWheel {
    private static final double MIN_TYRE_WEAR_CONDITION = 0.0;
    private static final double MAX_TYRE_WEAR_CONDITION = 1.0;
    private double tyreWearCondition;

    public CarWheel() {
        this.tyreWearCondition = MAX_TYRE_WEAR_CONDITION;
    }
}
