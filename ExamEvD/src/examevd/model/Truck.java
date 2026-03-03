
package examevd.model;

import examevd.service.DaoService;


public class Truck extends Vehicle implements DaoService{
    int weight;

    public Truck() {
    }

   

    public Truck(int weight, double regularPrice) {
        super(regularPrice);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if(weight > 2000){
            return regularPrice - (regularPrice * 0.1);
        }
        return regularPrice;
    }
    
    @Override
    public String color(String color){
        return color;
    }
    
    
}
