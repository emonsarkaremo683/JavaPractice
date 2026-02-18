package com.ensark.evdexam;

import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

//        checkPrime(s.nextInt());
//        int[] array;
//        array = new int[5];
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("Enter " + (i + 1) + " number");
//            array[i] = s.nextInt();
//        }
//        maxMix(array);
        
        fibonacci(8);

    }

    static void checkPrime(int input) {
        int count = 0;

        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                count++;
            }
        }

        if (count <= 2) {
            System.out.println("Prime number");
        } else {
            System.out.println("not a Prime Number");
        }

    }

    static void maxMix(int[] number) {
        int max = number[0];
        int min = number[0];

        for (int item : number) {
            if (max <= item) {
                max = item;
            }
            if (min >= item) {
                min = item;
            }

        }

        System.out.println("Largest Number is " + max);
        System.out.println("Lowest Number is " + min);

    }

    
    static void fibonacci(int n){
        int i = 0;
        int j = 1;
        System.out.print(i + " " + j + " ");
        for(int k = 1; k<n-1; k++ ){
            int temp = i + j;
            i = j;
            j = temp;
            System.out.print(temp + " ");
        }
    }
}
