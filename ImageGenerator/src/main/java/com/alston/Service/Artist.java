package com.alston.Service;

import com.alston.Model.Shapes.MyTriangle;

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
    int[] numbers;
    int primaryShape;
    int secondaryShape;
    int tertiaryShape;

    Color backGroundColor;
    Color primaryColor;
    Color secondaryColor;
    Color tertiaryColor;
    Pallet pallet = new Pallet();

    ShapeFactory shapeFactory = new ShapeFactory();

    BufferedImage bufferedImage;
    Graphics2D g2d;

    public Artist(int width, int height,int[] numbers){
        this.width = width;
        this.height = height;
        this.numbers = numbers;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();
        this.primaryColor = pallet.getColor(numbers[0]);
        this.secondaryColor = pallet.getColor(numbers[1]);
        this.tertiaryColor = pallet.getColor(numbers[2]);
        this.backGroundColor = pallet.getColor(numbers[3]);
        this.primaryShape = numbers[4];
        this.secondaryShape = numbers[5];
        this.tertiaryShape = numbers[6];

    }

    public void saveImage() throws IOException {
        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
    }

    public void drawVase(){
       // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.
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

    public void addStats(){
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
        // Create a graphics which can be used to draw into the buffered image
        int xOrigin = (width - width) / 2;
        int yOrigin = (height - height) / 2;

        //draw base
        g2d.setColor(backGroundColor);
        g2d.fillRect(xOrigin,yOrigin,width,height);

        //draw primary shape
        g2d.setColor(primaryColor);
        int shapeWidth = 50;
        int shapeHeight = 50;
        int xSpaces = width / shapeWidth;
        int ySpaces = height / shapeHeight;
        for(int y = 0; y < ySpaces; y+=3){
            int yPos = (y * shapeHeight)+yOrigin;
            for(int x = 0; x < xSpaces; x++){
                int xPos = (x * shapeWidth) + xOrigin;
                g2d.fill(shapeFactory.getShape(xPos,yPos,primaryShape));
            }

        }
        //draw shape
        g2d.setColor(secondaryColor);
        for(int y = 1; y < ySpaces; y+=3){
            int yPos = (y * shapeHeight)+yOrigin;
            for(int x = 0; x < xSpaces; x++){
                int xPos = (x * shapeWidth) + xOrigin;
                g2d.fill(shapeFactory.getShape(xPos,yPos,secondaryShape));
            }
        }
        //draw shape
        g2d.setColor(tertiaryColor);
        for(int y = 2; y < ySpaces; y+=3){
            int yPos = (y * shapeHeight)+yOrigin;
            for(int x = 0; x < xSpaces; x++){
                int xPos = (x * shapeWidth) + xOrigin;
                g2d.fill(shapeFactory.getShape(xPos,yPos,tertiaryShape));
            }
        }


    }



}
