package computearea;

import java.util.Scanner;

public class ComputeArea {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a Radius Value");
        System.out.println("Area of a circle: " + radius(s.nextFloat()));
    }

    private static float radius(float radius) {
        float area = (float) 3.1416 * radius * radius;
        return area;
    }  
    
}
