package practicepart;

import java.util.Arrays;
import java.util.Scanner;
import practicepart.arraysubclass.ArraySubcClass;

public class ArrayPractice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter size");

        int n = s.nextInt();
         ArraySubcClass ab = new ArraySubcClass();
        int[] arrays = ab.setArray(n, s);
        
        System.out.println("Your Max value is " + ab.maxValue(arrays));
        System.out.println("Your Min value is " + ab.minValue(arrays));
        ab.avgArrays(arrays);
        
        System.out.println("\nFinding odd even number in arrays");
        ab.oddEvenNumber(arrays);
        
        System.out.println("\nFinding prime number in arrays");
        ab.findPrimeNumber(arrays);

        System.out.println("\n Only Storing Prime numbers in array from an array");
        ab.arrayPrime(arrays);
        
        System.out.println("\n Bubble sorting from array \n" + Arrays.toString(ab.bubbleSort(arrays)));
        
        
    }

}
