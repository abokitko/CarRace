package com.labs.classes.Wheels;

import java.util.Objects;

public class Wheels {
    private int radius;
    public double wheelsFriction;
    private int uniqueID;


    public Wheels(int wheel_radius, double wheelsFriction){
        radius = wheel_radius;
        this.wheelsFriction = wheelsFriction;
        System.out.println("FRICTION ====> " + wheelsFriction);
        uniqueID = (Objects.hashCode(wheel_radius)+Objects.hashCode(wheelsFriction) + 560350593*2) % 1873624;
    }

    public int getRadius(){
        return radius;
    }
    public double getWheelsFriction(){return wheelsFriction;}
    public int getUniqueID(){return uniqueID;}
}
