package com.ensark.evdexam;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = 1;

        System.out.println("Enter number");
        int input = s.nextInt();

        for (int i = 1; i <= input; i++) {
            sum *= i;
        }

        System.out.println("Factorial of " + input + " is " + sum
        
        
        );
    }

}
