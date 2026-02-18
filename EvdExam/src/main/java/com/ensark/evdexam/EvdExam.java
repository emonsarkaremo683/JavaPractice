package com.ensark.evdexam;

import java.util.Scanner;

public class EvdExam {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter number");
        int input = s.nextInt();
        while (input >= 0) {
            sum += input;
            System.out.println("Enter number");
            input = s.nextInt();
        }

        System.out.println("Sum of all positive number " + sum);
    }
}
