package com.labs.classes.Transport;

import com.labs.classes.Engine.Engine;
import com.labs.classes.Wheels.Wheels;

import java.util.Objects;

public class Transport {
    private int mass;
    private int max_speed;
    private double friction;
    private Wheels wheels;
    private Engine engine;
    private int uniqueID;

    public Transport(int mass, int max_speed, double friction, Wheels wheels, Engine engine){
        this.mass = mass;
        this.max_speed = max_speed;
        this.friction = friction;
        this.wheels = wheels;
        this.engine = engine;
        uniqueID  = (Objects.hashCode(mass) + Objects.hashCode(max_speed) + Objects.hashCode(friction) + Objects.hashCode(wheels)+ Objects.hashCode(engine)) % 1147483647;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    /**
     * calculating speed with the formula and rounding it
     * @return speed
     */
    public  int getSpeed(){
        return  (int)Math.round(engine.getHP()*engine.getWM()/(wheels.getRadius()*mass*wheels.getWheelsFriction())*friction);
    }

    public Wheels getWheels(){return wheels;}
    public Engine getEngine(){return engine;}
    public int getMass(){return mass;}
    public int getMax_speed(){return max_speed;}
    public double getFriction(){return friction;}

    /**
     * @param coef - road coefficient
     * @return speed on current route part
     */
    public double getSpeedWithCoef(double coef){
        return getSpeed()*coef;
    }
}
