package com.labs.classes.Engine;

import com.labs.classes.Engine.Engine;

public class ElectricEngine extends Engine {

    private double powerCoefficient;
    double efficiency;

    public ElectricEngine(int horse_powers, int wheel_moment) {
        super(horse_powers, wheel_moment);
        this.powerCoefficient = powerCoefficient;
        this.efficiency = efficiency;
    }
}
