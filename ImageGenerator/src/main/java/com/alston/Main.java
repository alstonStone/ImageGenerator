package com.alston;

import com.alston.Service.Artist;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {

        Artist artist = new Artist();
        artist.drawVase(Color.green,Color.blue);


    }

}