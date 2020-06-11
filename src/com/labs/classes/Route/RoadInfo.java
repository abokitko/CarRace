package com.labs.classes.Route;

public class RoadInfo {
    public int length;
    public String material;
    public double coef;
    public String symbol;
    public Point point;
    public Route route;

    RoadInfo(String material, int point_x, int point_y, int length, double coef, String symbol){
        this.material = material;
        this.point = new Point(point_x, point_y);
        this.length = length;
        this.coef = coef;
        this.symbol = symbol;
    }
}
