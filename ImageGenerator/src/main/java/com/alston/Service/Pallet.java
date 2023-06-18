package com.alston.Service;

import java.awt.*;

public class Pallet {

    public Pallet(){}

    public Color getColor(int index){
        Color color = Color.BLACK;
        switch(index) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.decode("#7851a9");//RoyalPurple
                break;
            case 2:
                color = Color.green;
                break;
            case 3:
                color = Color.white;
                break;
            case 4:
                color = Color.decode("#404c09");//GrossGreen
                break;
            case 5:
                color = Color.blue;
                break;
            case 6:
                color = Color.red;
                break;
            case 7:
                color = Color.decode("#FFD700");//Gold
                break;
            case 8:
                color = Color.CYAN;
                break;
            case 9:
                color = Color.decode("#c0c0c0");//Silver
                break;
        }
        return color;
    }

}
