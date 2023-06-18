package com.alston.Service;

import com.alston.Model.Shapes.MyTriangle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ShapeFactory {

    public ShapeFactory(){

    }

    public Shape getShape(int x, int y,int shape){
        if(shape >=0 && shape <=2){
            return (new MyTriangle(x,y).getShape());
        }else if(shape >=3 && shape <=5){
            return (new MyTriangle(x,y).getShapeUpsideDown());
        }else if(shape >=6 && shape <=8){
            return new Rectangle2D.Double(x,y,50,50);
        }else{
            return new Ellipse2D.Double(x,y,50,50);
        }
    }





}
