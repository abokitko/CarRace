package com.labs.classes;

public class Wheels {
    private int radius;
    public double wheelsFriction;

    public Wheels(int wheel_radius, double wheelsFriction1){
        radius = wheel_radius;
        wheelsFriction = wheelsFriction1;
    }

    public int getRadius(){
        return radius;
    }

    public double getWheelsFriction(){return wheelsFriction;}
}
