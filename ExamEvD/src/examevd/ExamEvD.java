package examevd;

import examevd.model.Truck;

public class ExamEvD {

    public static void main(String[] args) {
        System.out.println("Without Discount");
        Truck t = new Truck(2000, 100);
        System.out.println("Weight: " + t.getWeight());
        System.out.println("Regular Price: " + t.getRegularPrice());
        System.out.println("Sale price is: " + t.getSalePrice());

        System.out.println("");
        System.out.println("==========================");
        System.out.println("");

        System.out.println("With Discount");
        Truck truck = new Truck(2500, 100);
        System.out.println("Weight: " + truck.getWeight());
        System.out.println("Regular Price: " + truck.getRegularPrice());
        System.out.println("Sale price is: " + truck.getSalePrice());
        System.out.println("");
        System.out.println("==========================");
        System.out.println("");
        System.out.println(t.color("red"));
    }

}
