
package com.ensark.evdexam;

import com.ensark.evdexam.Inherit.Truck;

public class TestInherit {
    public static void main(String[] args) {
        Truck t = new Truck(2500,200);
        
        System.out.println(t.getSalePrice());
    }
}
