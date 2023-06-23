package com.alston.Service;

import com.alston.Model.Shapes.MyTriangle;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//An Artist takes parameters and generates an image
public class Artist {
    //image size
    int width;
    int height;
    int shapeWidth = 50;
    int shapeHeight = 50;
    int[] numbers;
    int primaryShape;
    int secondaryShape;
    int tertiaryShape;
    int numShapes = 3;

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
        File file = new File("pattern.png");
        ImageIO.write(bufferedImage, "png", file);
    }
    public void makeGif() throws IOException {
        int numFrames = 6;
        BufferedImage[] frames = new BufferedImage[numFrames];
        int yShift = 25;
        for(int i = 0; i < numFrames; i++){
            frames[i] = bufferedImage.getSubimage(0,i * yShift,width,height-(numFrames*yShift));
        }
        BufferedImage first = frames[0];
        ImageOutputStream output = new FileImageOutputStream(new File("example.gif"));

        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 150, true);
        writer.writeToSequence(first);
        for (int i = numFrames-1; i >0 ; i--) {
            BufferedImage next = frames[i];
            writer.writeToSequence(next);
        }
        writer.close();
        output.close();
    }
    public void makeGif(int numFrames) throws IOException {
        BufferedImage[] frames = new BufferedImage[numFrames];
        int yShift = (numShapes * shapeHeight) / numFrames;
        for(int i = 0; i < numFrames; i++){
            frames[i] = bufferedImage.getSubimage(0,i * yShift,width,height-(numFrames*yShift));
        }
        BufferedImage first = frames[0];
        ImageOutputStream output = new FileImageOutputStream(new File("example.gif"));

        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), (1000 / numFrames), true);
        writer.writeToSequence(first);
        for (int i = numFrames-1; i >0 ; i--) {
            BufferedImage next = frames[i];
            writer.writeToSequence(next);
        }
        writer.close();
        output.close();
    }
//    public void drawVase() {
//        // Create a graphics which can be used to draw into the buffered image
//        Graphics2D g2d = bufferedImage.createGraphics();
//
//        int xCenter = width / 2;
//        int yCenter = height / 2;
//        // vase body
//        g2d.setColor(primaryColor);
//        g2d.fillOval(170,100, 160, 190);
//        g2d.setColor(Color.black);
//        g2d.drawOval(170,100, 160, 190);
//        //top of vase
//        g2d.setColor(secondaryColor);
//        g2d.fillOval(150,90, 200, 60);
//        g2d.setColor(Color.black);
//        g2d.drawOval(150,90, 200, 60);
//        //shadow in vase
//        g2d.setColor(primaryColor.darker());
//        g2d.fillOval(200,110, 100, 30);
//        // Disposes of this graphics context and releases any system resources that it is using.
//        g2d.dispose();
//    }


    public void drawVase() {
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        int xCenter = width / 2;
        int yCenter = height / 2;
        // vase body
        g2d.setColor(primaryColor);
        g2d.fillOval(170,yCenter - 70, (int) (160 + (height * .25)), 190);
        g2d.setColor(Color.black);
        g2d.drawOval(170,yCenter - 70, (int) (160 + (height * .25)), 190);
        //top of vase
        g2d.setColor(secondaryColor);
        g2d.fillOval(150,yCenter - 90, (int) (200 + (height * .25)), 60);
        g2d.setColor(Color.black);
        g2d.drawOval(150,yCenter - 90, (int) (200 + (height * .25)), 60);
        //shadow in vase
        g2d.setColor(primaryColor.darker());
        g2d.fillOval(200,yCenter - 80, (int) (100 + (height * .25)), 30);
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

        //draw shapes
        int xSpaces = width / shapeWidth;
        int ySpaces = height / shapeHeight;

        for(int y = 0; y < ySpaces; y++){
            int row = y % 3;
            int shape;
            Color color;
            switch(row) {
                case 0:
                    shape = primaryShape;
                    color = primaryColor;
                    break;
                case 1:
                    shape = secondaryShape;
                    color = secondaryColor;
                    break;
                case 2:
                    shape = tertiaryShape;
                    color = tertiaryColor;
                    break;
                default:
                    shape = primaryShape;
                    color = primaryColor;
                    break;
            }
            int yPos = (y * shapeHeight)+yOrigin;
            g2d.setColor(color);
            for(int x = 0; x < xSpaces; x++){
                int xPos = (x * shapeWidth) + xOrigin;
                g2d.fill(shapeFactory.getShape(xPos,yPos,shape));
            }
        }
    }




}
