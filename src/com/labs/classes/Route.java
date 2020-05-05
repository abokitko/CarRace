package com.labs.classes;
import java.util.ArrayList;

public class Route {

    public ArrayList<RoadInfo> list;
    Road road;


    public Route(){
        list = new ArrayList<RoadInfo>();
    }

    //car move straight => y = 0
    public void addMaterial(){
        list.add(new RoadInfo("asphalt", 0, 0, 20, 4, "."));
        list.add(new RoadInfo("gravel", 20, 0, 12, 12, "#"));
        list.add(new RoadInfo("sand", 32, 0, 3, 1, "~"));
    }

    public RoadInfo getRoad(int index){
        return list.get(index);
    }
}
