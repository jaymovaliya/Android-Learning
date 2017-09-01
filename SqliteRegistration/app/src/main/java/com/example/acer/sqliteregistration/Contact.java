package com.example.acer.sqliteregistration;

/**
 * Created by acer on 6/13/2017.
 */

public class Contact {
    private  Integer id;
    private String username;
    private String address;
    private String mobileno;
    private String dob;
    Contact(){}
    Contact(String name,String add,String mob,String birth){
        this.username = name;
        this.address = add;
        this.mobileno = mob;
        this.dob = birth;
    }
    public void setName(String name){
        this.username = name;
    }
    public String getName(){
        return username;
    }
    public void setAddress(String add){
        this.address = add;
    }
    public String getAddress(){
        return address;
    }
    public void setMobileno(String mob){
        this.mobileno = mob;
    }
    public String getMobileno(){
        return mobileno;
    }
    public void setDob(String birth){
        this.dob = birth;
    }
    public String getDob(){
        return dob;
    }
}
