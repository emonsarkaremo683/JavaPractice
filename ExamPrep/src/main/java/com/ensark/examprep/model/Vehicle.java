
package com.ensark.examprep.model;


public class Vehicle {
    
    protected int speed;
    protected double regularPrice;
    protected String color;

    public Vehicle() {
    }

    public Vehicle(double regularPrice) {
        this.regularPrice = regularPrice;
    }
    
    public double getSalePrice(){
        return regularPrice;
    }
}
