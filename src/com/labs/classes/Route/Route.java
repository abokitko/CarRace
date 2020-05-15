package com.labs.classes.Route;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Route {

    public ArrayList<RoadInfo> list;
    Road road;
    private int[] roadLengths;

    /**
     * creating a list for route parts
     */
    public Route(int[] roadLengths){
        this.roadLengths = roadLengths;
        list = new ArrayList<RoadInfo>();
    }

    /**
     *filling a list of route parts with their characteristics
     */
    //car move straight => y = 0
    public void addMaterial(){
        list.add(new RoadInfo("asphalt", 0, 0, this.roadLengths[0], 1, "."));
        list.add(new RoadInfo("gravel", 20, 0, this.roadLengths[1], 0.9, "#"));
        list.add(new RoadInfo("sand", 32, 0, this.roadLengths[2], 0.85, "~"));
    }

    /**
     * allows the method show to get the index of the current route part
     * @param index index of the route part
     * @return indexes of list items
     */
    public RoadInfo getRoad(int index){
        return list.get(index);
    }
}
