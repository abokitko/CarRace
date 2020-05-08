package com.labs;

import com.labs.classes.Engine.Engine;
import com.labs.classes.Route.Route;
import com.labs.classes.Transport.Car;
import com.labs.classes.Wheels.Wheels;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main {
    public static void getWinner(Road road) {
        if (road.getCounter1() > road.getCounter2()) {
            System.out.println("Winner: car1");
        } else if (road.getCounter2() > road.getCounter1()) {
            System.out.println("Winner: car2");
        } else {
            System.out.println("Draw");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       /* Wheels wheels1 = new Wheels(17, 0.95);
        Wheels wheels2 = new Wheels(12, 0.1);
        Wheels wheels3 = new Wheels(14, 0.5);

        Engine engine1 = new Engine(200, 700);
        Engine engine2 = new Engine(270, 750);
        Engine engine3 = new Engine(260, 720);

        Car car1 = new Car(650, 270, 0.2, wheels1, engine1);
        Car car2 = new Car(700, 250, 0.27, wheels2, engine2);
        Car car3 = new Car(710, 290, 0.3, wheels3, engine3);
*/

        Class Car = Class.forName("com.labs.classes.Transport.Car");
        Class[] carConstructorParameterTypes = {int.class, int.class, double.class, Wheels.class, Engine.class};
        Constructor carConstructor = Car.getConstructor(carConstructorParameterTypes);


        Scanner in = new Scanner(System.in);

        Car car1 = null;
        Car car2 = null;
        Car car3 = null;

        for (int i = 0; i < 2; i++) {
            System.out.println("Input the number of the car (1,2,3): ");
            int number = in.nextInt();

            if (number == 1) {
                car1 = (com.labs.classes.Transport.Car) carConstructor.newInstance(650, 270, 0.2,  new Wheels(17,0.47), new Engine(200, 700));
            } else if (number == 2) {
                car2 = (com.labs.classes.Transport.Car) carConstructor.newInstance(1, 1, 0.1,  new Wheels(9, 0.87), new Engine(170, 550));
            } else if (number == 3) {
                car3 = (com.labs.classes.Transport.Car) carConstructor.newInstance(710, 290, 0.76, new Wheels(14, 0.3), new Engine(260, 720));
            } else {
                System.out.println("There is no such car");
            }
        }

        Class Transport = Class.forName("com.labs.classes.Transport.Transport");
        Method getSpeed = Transport.getDeclaredMethod("getSpeed", null);
        //Method getSpeed = Car.getDeclaredMethod("getSpeed", null);
        int speed1 = 0;
        int speed2 = 0;
        int speed3 = 0;

        Route route = new Route();
        Road road = null;
        route.addMaterial();

        if (car1 != null) {
            speed1 = (int) getSpeed.invoke(car1, null);
        }

        if (car2 != null) {
            speed2 = (int) getSpeed.invoke(car2, null);
        }

        if (car3 != null) {
            speed3 = (int) getSpeed.invoke(car3, null);
        }

        if(speed1 != 0 && speed2 != 0){
            road = new Road(speed1, speed2, route);
        }

        if(speed1 != 0 && speed3 != 0){
            road = new Road(speed1, speed3, route);
        }

        if(speed2 != 0 && speed3 != 0){
            road = new Road(speed2, speed3, route);
        }

        road.show();
        road.warning();

        getWinner(road);
    }
}

