package com.example.acer.recyclerview;

/**
 * Created by acer on 6/12/2017.
 */

public class fruit {
    private String fname,fcolor;
    private Integer fimageid;
    public fruit(){}
    public fruit(String name, String color, Integer imageid){
        this.fname = name;
        this.fcolor = color;
        this.fimageid = imageid;
    }
    public void setName(String name){
        this.fname = name;
    }
    public String getName(){
        return fname;
    }
    public void setColor(String color){
        this.fcolor = color;
    }
    public String getColor(){
        return fcolor;
    }
    public void setImage(Integer imageid){
        this.fimageid = imageid;
    }
    public Integer getImage(){
        return fimageid;
    }
}
