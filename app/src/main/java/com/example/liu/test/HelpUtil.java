package com.example.liu.test;

public class HelpUtil {
    private static long lastClickTime;
    public static  boolean isFastDoubleClick(){
        long time=System.currentTimeMillis();
        if(time-lastClickTime<5000){
                return true;
        }
        lastClickTime=time;
        return false;
    }
}
