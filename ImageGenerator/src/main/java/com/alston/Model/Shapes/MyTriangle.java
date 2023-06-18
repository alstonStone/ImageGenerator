package com.alston.Model.Shapes;

import java.awt.*;

public class MyTriangle {
    private final int x;
    private final int y;
    int width = 50;
    int height = 50;
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];

    public MyTriangle(int x, int y){

        this.x = x;
        this.y = y;



    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public Shape getShape(){

        xPoints[0] = 0 + x;
        xPoints[1] = 25 + x;
        xPoints[2] = 50 + x;

        yPoints[0] = 50 + y;
        yPoints[1] = 0 + y;
        yPoints[2] = 50 + y;

        return new Polygon(xPoints,yPoints,3);
    }
    public Shape getShapeUpsideDown(){

        xPoints[0] = 0 + x;
        xPoints[1] = 25 + x;
        xPoints[2] = 50 + x;

        yPoints[0] = 0 + y;
        yPoints[1] = 50 + y;
        yPoints[2] = 0 + y;
        return new Polygon(xPoints,yPoints,3);
    }

}
