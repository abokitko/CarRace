package com.labs.classes;
import java.util.ArrayList;

public class Route {

    public ArrayList<RoadInfo> list;
    Road road;

    /**
     * creating a list for route parts
     */
    public Route(){
        list = new ArrayList<RoadInfo>();
    }

    /**
     *filling a list of route parts with their characteristics
     */
    //car move straight => y = 0
    public void addMaterial(){
        list.add(new RoadInfo("asphalt", 0, 0, 20, 4, "."));
        list.add(new RoadInfo("gravel", 20, 0, 12, 12, "#"));
        list.add(new RoadInfo("sand", 32, 0, 3, 1, "~"));
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
