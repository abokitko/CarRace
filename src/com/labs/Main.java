package com.labs;

import com.labs.classes.NoSuchCar;
import com.labs.classes.Route.*;
import com.labs.classes.Transport.*;
import com.labs.classes.exception.UnableToReadException;
import com.labs.classes.reader.StreamTextFileReader;

import java.lang.reflect.InvocationTargetException;

public class Main {
    private static Road road;
    private static Car car1, car2;

    /**
     * compares the end positions of the cars
     * @param
     */
    public static void getWinner() {
        if (road.getCounter1() > road.getCounter2()) {
            System.out.println("Winner: car1");
        } else if (road.getCounter2() > road.getCounter1()) {
            System.out.println("Winner: car2");
        } else {
            System.out.println("Draw");
        }
    }

    public static int[] getRoutePoints(String buf) {
        String[] temp;
        temp = buf.split(",");
        int[] routePointsArray = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            routePointsArray[i] = Integer.parseInt(temp[i]);
        }
        return routePointsArray;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, UnableToReadException {
        CarFactory carFactory = new CarFactory();

        try {
            car1 = carFactory.createCar();
            car2 = carFactory.createCar();
        } catch(ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |IllegalAccessException | NoSuchCar e){
            e.printStackTrace();
        }
        String path = "src/com/labs/data.txt";


        Route route = new Route(getRoutePoints(new StreamTextFileReader(path).read()));
        route.addMaterial();

        road = new Road(car1.getSpeed(), car2.getSpeed(), route);
        road.show();
        road.warning();

        getWinner();
    }
}

