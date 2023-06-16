package com.alston.Service;

import java.util.Random;

public class RandomNumberJesus {

    int[] numbers;

    public RandomNumberJesus(){
        numbers = new int[6];
        Random rand = new Random();
        for(int i = 0; i < 6 ;i++){
            numbers[i] = rand.nextInt(10);
        }
    }

    public RandomNumberJesus(int n){
        numbers = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n ;i++){
            numbers[i] = rand.nextInt(10);
        }
    }

    public int[] getNumbers(){
        return this.numbers;
    }

}
