package com.labs.classes.Transport;

import com.labs.classes.Engine.Engine;
import com.labs.classes.Wheels.Wheels;

public class Car extends Transport {

    public Car(int mass, int max_speed, double friction, Wheels wheels, Engine engine) {
        super(mass, max_speed, friction, wheels, engine);
    }
}
