package com.labs.classes.Route;

public class RoadInfo {
    public int length;
    public String material;
    public int coef;
    public String symbol;
    public Point point;

    RoadInfo(String material, int point_x, int point_y, int length, int coef, String symbol){
        this.material = material;
        this.point = new Point(point_x, point_y);
        this.length = length;
        this.coef = coef;
        this.symbol = symbol;
    }
}
