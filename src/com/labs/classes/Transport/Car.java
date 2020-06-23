package com.labs.classes.Transport;

import com.labs.classes.Engine.Engine;
import com.labs.classes.Wheels.Wheels;

import java.util.Objects;

public class Car extends Transport {

    private int uniqueID;

    public Car(int mass, int max_speed, double friction, Wheels wheels, Engine engine) {
        super(mass, max_speed, friction, wheels, engine);
        uniqueID  = (Objects.hashCode(mass) + Objects.hashCode(max_speed) + Objects.hashCode(friction) + Objects.hashCode(wheels)+ Objects.hashCode(engine)) % 1147483647;
    }

    public int getUniqueID(){return uniqueID;}

//    @Override
//    public int getSpeed(){
//        return super.getSpeed()*2;
//    }

}
