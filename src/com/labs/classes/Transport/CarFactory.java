package com.labs.classes.Transport;

import com.labs.classes.NoSuchCar;
import com.labs.classes.Engine.Engine;
import com.labs.classes.Wheels.Wheels;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;



public class CarFactory {

    public Car car;
    private Transport transport;


    public Car createCar() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchCar {

        Class Car = Class.forName("com.labs.classes.Transport.Car");
        Class[] carConstructorParameterTypes = {int.class, int.class, double.class, Wheels.class, Engine.class};
        Constructor carConstructor = Car.getConstructor(carConstructorParameterTypes);

        Scanner in = new Scanner(System.in);

        car = null;

        System.out.println("Input the number of the car (1,2,3): ");
        int number = in.nextInt();

        if (number == 1) {
            car = (com.labs.classes.Transport.Car) carConstructor.newInstance(650, 270, 0.2, new Wheels(17, 0.47), new Engine(200, 700));
            System.out.println("Created car 1");
        } else if (number == 2) {
            car = (com.labs.classes.Transport.Car) carConstructor.newInstance(630, 240, 0.34, new Wheels(16, 0.87), new Engine(170, 550));
            System.out.println("Created car 2");
        } else if (number == 3) {
            car = (com.labs.classes.Transport.Car) carConstructor.newInstance(710, 290, 0.76, new Wheels(14, 0.3), new Engine(260, 720));
            System.out.println("Created car 3");
        } else {
            throw new NoSuchCar("!!!!");
        }

        return car;
    }
}
