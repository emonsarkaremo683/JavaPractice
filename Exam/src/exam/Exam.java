package exam;

import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take two integers and sum of them. 1st Question
        /*
        System.out.println("Enter first Value");
        int a = sc.nextInt();
        System.out.println("Enter Second Value");
        int b = sc.nextInt();
        System.out.println("Sum of the numbers: " + (a + b));
        */
        
        // inputed name printed with welcome text. 2nd Question
        /*
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Welcome " + name);
        */
        
        
        
        
        System.out.println("Enter a number");
        float radius = sc.nextFloat();
        float areaOfCircle;
        
        if(radius <= 0){
            System.out.println("Enter a valid number");
        } else {
            areaOfCircle = (float)(Math.PI * Math.pow(radius, 2));
            System.out.println("Area of a Circle is " + areaOfCircle);
        }
        
        

    }

}
