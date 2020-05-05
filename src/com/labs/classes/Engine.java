package com.labs.classes;

public class Engine {
    private int horse_powers;
    private int wheel_moment;

    public Engine(int horse_powers, int wheel_moment){
        this.horse_powers = horse_powers;
        this.wheel_moment = wheel_moment;
    }

    public int getHP(){
        return horse_powers;
    }

    public int getWM(){
        return wheel_moment;
    }
}
