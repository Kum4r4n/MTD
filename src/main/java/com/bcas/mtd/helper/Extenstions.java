package com.bcas.mtd.helper;

public class Extenstions {

    public static int generateInt(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
