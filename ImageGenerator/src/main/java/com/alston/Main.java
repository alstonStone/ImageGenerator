package com.alston;

import com.alston.Model.Rug;
import com.alston.Service.Artist;
import com.alston.Service.Pallet;
import com.alston.Service.RandomNumberJesus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {

        RandomNumberJesus rnj = new RandomNumberJesus(6);//3colors + 3 shapes

        for(Integer i: rnj.getNumbers()){
            System.out.print(i+" ");
        }

        Artist artist = new Artist(300,500, rnj.getNumbers());
        artist.drawRug();
        artist.saveImage();



    }

}