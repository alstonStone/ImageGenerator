package com.alston;

import com.alston.Service.Artist;
import com.alston.Service.RandomNumberJesus;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        RandomNumberJesus rnj = new RandomNumberJesus(7);//3colors + 3 shapes
        for(Integer i: rnj.getNumbers()){
            System.out.print(i+" ");
        }
        //for testing
//        int[] testingNumbers = new int[]{0, 4, 2, 0, 9, 9, 9};
//        Artist artist = new Artist(300*3,600*3,testingNumbers);

        Artist artist = new Artist(5400,7200, rnj.getNumbers());

        artist.drawPoster();
        artist.saveImageJpg("poster");
//        artist.makeGif(50);
    }

}