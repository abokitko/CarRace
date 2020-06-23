package com.labs.classes.Transport;

import com.labs.classes.NoSuchCar;
import com.labs.classes.Engine.Engine;
import com.labs.classes.Wheels.Wheels;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;



public class CarFactory {

    public Car car;
    public SportCar sportCar;
    public Truck truck;
    private Transport transport;


    public Transport createTransport() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchCar {

        Class Car = Class.forName("com.labs.classes.Transport.Car");
        Class[] carConstructorParameterTypes = {int.class, int.class, double.class, Wheels.class, Engine.class};
        Constructor carConstructor = Car.getConstructor(carConstructorParameterTypes);

        Class SportCar = Class.forName("com.labs.classes.Transport.SportCar");
        Class[] sportCarConstructorParameterTypes = {int.class, int.class, double.class, Wheels.class, Engine.class};
        Constructor SportCarConstructor = SportCar.getConstructor(sportCarConstructorParameterTypes);

        Class Truck = Class.forName("com.labs.classes.Transport.Truck");
        Class[] truckConstructorParameterTypes = {int.class, int.class, double.class, Wheels.class, Engine.class};
        Constructor TruckConstructor = Truck.getConstructor(truckConstructorParameterTypes);

        Scanner in = new Scanner(System.in);

        car = null;
        sportCar = null;
        truck = null;

        System.out.println("Choose the car: car(1), sport car(2), truck(3)");
        int number = in.nextInt();

        if (number == 1) {
            transport = (com.labs.classes.Transport.Car) carConstructor.newInstance(650, 270, 0.29, new Wheels(17, 0.87), new Engine(170, 550));
            System.out.println("Created car");
        } else if (number == 2) {
            transport = (com.labs.classes.Transport.SportCar) SportCarConstructor.newInstance(630, 270, 0.25, new Wheels(17, 0.47), new Engine(200, 700));
            System.out.println("Created sport car");
        } else if (number == 3) {
            transport = (com.labs.classes.Transport.Truck) TruckConstructor.newInstance(710, 290, 0.76, new Wheels(14, 0.3), new Engine(260, 720));
            System.out.println("Created truck");
        } else {
            throw new NoSuchCar("!!!!");
        }

        return transport;
    }
}

