package classtest.supclass;

public class Truck extends Vehicle {

    private int weight;

    public Truck() {
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, double regularPrice) {
        super(regularPrice);
        this.weight = weight;
    }
    

    public Truck(int weight, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
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
//         if (weight > 2000) {
//            System.out.print("After Discounted: ");
//            return super.getRegularPrice() - (super.getRegularPrice() * .10);
//        } else {
//            System.out.println("Not eligible for discount: ");
//            return super.getRegularPrice();
//        }

        return (weight > 2000) ? super.getRegularPrice() - (super.getRegularPrice() * .10) :super.getRegularPrice();
    }
    
    


}
