package com.alston.Service;


import java.awt.*;
import java.awt.image.BufferedImage;

//creates 18X24 posters
public class PosterFactory {

    int width = 5400;
    int height = 7200;

    public PosterFactory(){}

    public BufferedImage drawPoster(){
        BufferedImage poster = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = poster.createGraphics();






        return poster;
    }
    public void drawPattern(){
        
    }



}
