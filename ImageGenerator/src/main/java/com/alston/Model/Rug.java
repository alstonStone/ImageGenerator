package com.alston.Model;

import com.alston.Model.Shapes.MyTriangle;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rug {


    String primaryShape;
    String secondaryShape;
    String tertiaryShape;

    Color primaryColor;
    Color secondaryColor;
    Color tertiaryColor;

    public int height = 500;
    public int width = 300;

    public Rug(
            Color primaryColor, Color secondaryColor, Color tertiaryColor,
            String primaryShape, String secondaryShape, String tertiaryShape){
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.tertiaryColor = tertiaryColor;
        this.primaryShape = primaryShape;
        this.secondaryShape = secondaryShape;
        this.tertiaryShape = tertiaryShape;
    }

    public BufferedImage getRug() {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.fill(new MyTriangle(0,0).getShape());

        g2d.dispose();
        return bufferedImage;
    }
}
