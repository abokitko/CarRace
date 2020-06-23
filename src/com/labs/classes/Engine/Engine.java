package com.labs.classes.Engine;

import java.util.Objects;

public class Engine {
    private int horse_powers;
    private int wheel_moment;
    private int uniqueID;

    public Engine(int horse_powers, int wheel_moment){
        this.horse_powers = horse_powers;
        this.wheel_moment = wheel_moment;
        uniqueID = (Objects.hashCode(horse_powers) + Objects.hashCode((wheel_moment))) % 1147483647;
    }

    public int getHP(){
        return horse_powers;
    }

    public int getWM(){
        return wheel_moment;
    }

    public int getUniqueID() { return uniqueID;}
}
