package com.labs.classes.Route;

import java.io.IOException;

public class Road {
    private int coord1 = 0;
    private int coord2 = 0;
    private int speed1;
    private int speed2;
    private int roadLength = 35;
    private Route route;
    public int counter1 = 0;
    public int counter2 = 0;

    public Road(int speed1, int speed2, Route route) {
        this.speed1 = speed1;
        this.speed2 = speed2;
        this.route = route;
    }

    /**
     *
     * @param amount - speed based on the road coefficient (symbols/tick)
     * @param symbol - symbol of road material
     * @return pointsString -the length of the path distance
     */
    public String points(int amount, String symbol) {
        String pointsString = "";
        for (int i = 0; i < amount; i++) {
            pointsString += symbol;
        }
        return pointsString;
    }

    public static void promptEnterKey() {
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * shows the race progress to the console
     */
    public void show() {

        String outString1 = "";
        String outString2 = "";

        int currentTick = 0;

        int currentRoad1 = 0;
        int currentRoad2 = 0;


        while (currentTick != roadLength && currentRoad1 < 3 && currentRoad2 < 3) { // Здесь будет условие с количеством тактов roadLength
            promptEnterKey();

            int amount1 = speed1 * route.getRoad(currentRoad1).coef;

            if (amount1 > (route.getRoad(currentRoad1).length - coord1)) {
                amount1 = route.getRoad(currentRoad1).length - coord1;
            }

            int amount2 = speed2 * route.getRoad(currentRoad2).coef;

            if (amount2 > (route.getRoad(currentRoad2).length - coord2)) {
                amount2 = route.getRoad(currentRoad2).length - coord2;
            }

            coord1 += amount1;
            coord2 += amount2;

            counter1 += amount1;
            counter2 += amount2;

            outString1 += points(amount1, route.getRoad(currentRoad1).symbol);
            outString2 += points(amount2, route.getRoad(currentRoad2).symbol);


            System.out.println(outString1);
            System.out.println(outString2);

            if (coord1 >= route.getRoad(currentRoad1).length) {
                coord1 = 0;
                currentRoad1++;
            } else {
                currentRoad1 = currentRoad1;
            }

            if (coord2 >= route.getRoad(currentRoad2).length) {
                coord2 = 0;
                currentRoad2++;
            } else {
                currentRoad2 = currentRoad2;
            }

            System.out.println("speed1: " + amount1 + ", " + "speed2: " + amount2 + " (points/tick)");
            System.out.println("location1: " + counter1 + ", location2:  " + counter2);
            System.out.println();
        }
    }


    /**
     * compares the winner's endpoint with the length of the route
     */
    public void warning() {
        if (counter1 < roadLength && counter2 < roadLength) {
            System.out.println("Warning! The race was interrupted. The length of the route and its parts do not match");
            System.exit(0);
        }
    }

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }
}
