package com.ensark.examprep.model;

public class Truck extends Vehicle {

    protected int weight;

    public Truck() {
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, double regularPrice) {
        super(regularPrice);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        return (weight > 2000) ? regularPrice * .9 : regularPrice;
    }

}
