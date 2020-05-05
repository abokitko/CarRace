package com.labs.classes;

public class Transport {
    private int mass;
    private int max_speed;
    private double friction;
    private Wheels wheels;
    private Engine engine;

    public Transport(int mass, int max_speed, double friction, Wheels wheels, Engine engine){
        this.mass = mass;
        this.max_speed = max_speed;
        this.friction = friction;
        this.wheels = wheels;
        this.engine = engine;
    }


    public  int getSpeed(){
        return (int)Math.round(engine.getHP()*engine.getWM()/(wheels.getRadius()*mass*wheels.getWheelsFriction())*friction);
    }

    public double getSpeedWithCoef(double coef){
        return getSpeed()*coef;
    }
}
