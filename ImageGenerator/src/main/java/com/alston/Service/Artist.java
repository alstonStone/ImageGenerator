package com.alston.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//An Artist takes parameters and generates an image
public class Artist {
    //image size
    int width;
    int height;
    String primaryShape;
    String secondaryShape;
    String tertiaryShape;

    Color primaryColor;
    Color secondaryColor;
    Color tertiaryColor;
    Pallet pallet = new Pallet();
    ShapeService shapeService = new ShapeService();

    BufferedImage bufferedImage;

    public Artist(int width, int height,int[] numbers){
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.primaryColor = pallet.getColor(numbers[0]);
        this.secondaryColor = pallet.getColor(numbers[1]);
        this.tertiaryColor = pallet.getColor(numbers[2]);
        this.primaryShape = shapeService.getShape(numbers[3]);
        this.secondaryShape = shapeService.getShape(numbers[4]);
        this.tertiaryShape = shapeService.getShape(numbers[5]);
        addStats(numbers);
    }

    public void saveImage() throws IOException {
        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
    }

    public void drawVase(){
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
    }

    public void drawVase(Color primary, Color secondary) {
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
    }

    public void addStats(int[] numbers){
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, 20);

        String text = "";

        for(int i = numbers.length -1; i >=0; i--){
            if((i+1)%3 == 0 && i!= numbers.length-1){
                text = numbers[i]+"," + text;
            }else{
                text = numbers[i]+ text;
            }

        }
        text = text + " / 1,000,000";
        g2d.setColor(Color.black);
        g2d.drawString(text,0,15);
        g2d.dispose();
    }

    public void drawRug(){

    }



}
