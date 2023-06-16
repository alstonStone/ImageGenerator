package com.alston.Model.Shapes;

import java.awt.*;

public class MyTriangle {

    int[] xPoints = new int[]{0,30,60};
    int[] yPoints = new int[]{30,0,30};

    public MyTriangle(){}

    public Shape getShape(){

        return new Polygon(xPoints,yPoints,3);
    }

}
