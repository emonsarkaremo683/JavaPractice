
package com.ensark.evdexam.Inherit;

public class Truck extends Vehicle{

    int weight;

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, double regularPrice) {
        super(regularPrice);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if(weight > 2000){
            return regularPrice - (regularPrice * .1);
        }
        return regularPrice;
    }

    
    
}
