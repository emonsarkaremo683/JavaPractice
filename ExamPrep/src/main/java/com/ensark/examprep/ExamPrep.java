package com.ensark.examprep;

import com.ensark.examprep.model.Truck;


public class ExamPrep {

    public static void main(String[] args) {
        Truck truck = new Truck(2500,200);
        System.out.println(truck.getSalePrice());
    }
}
