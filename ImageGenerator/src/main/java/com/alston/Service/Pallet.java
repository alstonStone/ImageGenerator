package com.alston.Service;

import java.awt.*;

public class Pallet {

    private final Color primary;
    private final Color secondary;

    public Pallet(int p, int s){
        this.primary = getColor(p);
        this.secondary = getColor(s);
    }

    public Color getPrimary(){
        return this.primary;
    }

    public Color getSecondary(){
        return this.secondary;
    }

    private Color getColor(int index){
        Color color = Color.BLACK;
        switch(index) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.decode("#7851a9");
                break;
            case 2:
                color = Color.green;
                break;
            case 3:
                color = Color.white;
                break;
            case 4:
                color = Color.decode("#404c09");
                break;
            case 5:
                color = Color.blue;
                break;
            case 6:
                color = Color.red;
                break;
            case 7:
                color = Color.decode("#FFD700");
                break;
            case 8:
                color = Color.CYAN;
                break;
            case 9:
                color = Color.decode("#c0c0c0");
                break;
        }
        return color;
    }

}
