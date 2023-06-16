package com.alston;

import com.alston.Model.Rug;
import com.alston.Service.Artist;
import com.alston.Service.Pallet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {

//        Random rand = new Random();
//        int p = rand.nextInt(10);
//        int s = rand.nextInt(10);
//        System.out.println("p: "+p+" s: "+s);
//
//        Pallet pallet = new Pallet(p,s);
//
//
//        System.out.println("p: "+pallet.getPrimary().toString()+" s: "+pallet.getSecondary().toString());
//
//
//        Artist artist = new Artist(500,300);
//        artist.drawVase(pallet.getPrimary(),pallet.getSecondary());
//        String stats = ("Stats: p-"+p+"/10 s-"+s+"/10");
//        artist.addStats(stats);
        Rug rug = new Rug();
        Artist artist = new Artist(rug.width,rug.height);
        File file = new File("myimage.png");
        ImageIO.write(rug.getBufferedImage(), "png", file);



    }

}