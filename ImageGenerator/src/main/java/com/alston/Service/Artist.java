package com.alston.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Artist {
    int width = 500;
    int height = 300;

    public Artist(){

    }

    public void drawVase() throws IOException {
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        // create a circle with black
        g2d.setColor(Color.black);
        g2d.fillOval(170,100, 160, 190);
        // create a string with yellow
        g2d.setColor(Color.yellow);
        g2d.fillOval(150,90, 200, 60);
        g2d.setColor(Color.black);
        g2d.drawOval(150,90, 200, 60);
        g2d.fillOval(200,110, 100, 30);
        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();
        // Save as PNG
        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
    }

    public void drawVase(Color primary, Color secondary) throws IOException {
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        //background to white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        // vase body
        g2d.setColor(primary);
        g2d.fillOval(170,100, 160, 190);
        g2d.setColor(Color.black);
        g2d.drawOval(170,100, 160, 190);
        //top of vase
        g2d.setColor(secondary);
        g2d.fillOval(150,90, 200, 60);
        g2d.setColor(Color.black);
        g2d.drawOval(150,90, 200, 60);
        //shadow in vase
        g2d.setColor(primary.darker());
        g2d.fillOval(200,110, 100, 30);
        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();
        // Save as PNG
        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
    }



}
