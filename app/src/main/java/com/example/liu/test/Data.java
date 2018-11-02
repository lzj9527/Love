package com.example.liu.test;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Data implements Serializable {
    private  int imageId;
    private String value1;
    private String value2;
    public   Data(int imageId,String value1 ,String value2){
            this.imageId=imageId;
            this.value1=value1;
            this.value2=value2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
