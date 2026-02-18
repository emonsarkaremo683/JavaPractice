package com.ensark.evdexam.Inherit;

public class Vehicle {

    int speed;
    String color;
    double regularPrice;

    public Vehicle() {
    }

    public Vehicle(double regularPrice) {
        this.regularPrice = regularPrice;
    }
    
    

    public double getSalePrice() {
        return regularPrice;
    }

}
