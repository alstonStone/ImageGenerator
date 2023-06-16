package com.alston.Model;

import com.alston.Model.Shapes.MyTriangle;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rug {


    Shape primaryShape;
    Shape secondaryShape;
    Shape tertiaryShape;

    Color primaryColor;
    Color secondaryColor;
    Color tertiaryColor;

    public int height = 500;
    public int width = 300;

    boolean fringe;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


    public  Rug(){
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.fill(new MyTriangle().getShape());

        g2d.dispose();
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
