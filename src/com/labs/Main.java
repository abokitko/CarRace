package com.labs;

import com.labs.classes.Engine.*;
import com.labs.classes.Route.*;
import com.labs.classes.Transport.*;
import com.labs.classes.Wheels.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    private static Road road;
    private static Car car1, car2;

    /**
     * compares the end positions of the cars
     * @param road
     */
    public static void getWinner(Road road) {
        if (road.getCounter1() > road.getCounter2()) {
            System.out.println("Winner: car1");
        } else if (road.getCounter2() > road.getCounter1()) {
            System.out.println("Winner: car2");
        } else {
            System.out.println("Draw");
        }
    }



    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        CarFactory carFactory = new CarFactory();

        Route route = new Route();
        route.addMaterial();

        try {
            car1 = carFactory.createCar();
            car2 = carFactory.createCar();
        } catch(ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |IllegalAccessException | NoSuchCar e){
            e.printStackTrace();
        }

        road = new Road(car1.getSpeed(), car2.getSpeed(), route);
        road.show();
        road.warning();

        getWinner(road);
    }
}

