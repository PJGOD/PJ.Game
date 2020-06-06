package com.pj;

public class Utils2{
    //0不掉落药水1掉落药水
    private static int min=0;
    private static int max=2;
    public static int randomPotion(){
        return (int)(Math.random()*(max-min)+min);
    }
}
