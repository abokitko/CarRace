package com.labs.classes.Wheels;

public class Wheels {
    private int radius;
    public double wheelsFriction;


    public Wheels(int wheel_radius, double wheelsFriction){
        radius = wheel_radius;
        this.wheelsFriction = wheelsFriction;
    }

    public int getRadius(){
        return radius;
    }
    public double getWheelsFriction(){return wheelsFriction;}
}
