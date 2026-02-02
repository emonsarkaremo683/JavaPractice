package practicepart.arraysubclass;

import java.util.Scanner;

public class ArraySubcClass {

    
   

    public ArraySubcClass() {

    }

    public int[] setArray(int n, Scanner s) {
        int[] myArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your " + (i + 1) + " number");
            myArray[i] = s.nextInt();
        }

        return myArray;
    }

    public int maxValue(int[] myArray) {
        
        int max = 0;
        for (int item : myArray) {
            if (item >= max) {
                max = item;
            }
        }
        return max;
    }

    public int minValue(int[] myArray) {
        
        int min = myArray[0];
        for (int item : myArray) {
            if (item <= min) {
                min = item;
            }
        }
        return min;
    }

    public void avgArrays(int[] myArray) {
       

        int sum = 0;
        for (int item:myArray) {
            sum += item;
        }

        System.out.println("Average number of array " + (double) (sum / myArray.length));
    }

    public void oddEvenNumber(int[] myArray) {
       
        for (int item:myArray) {
            if (item % 2 == 0) {
                System.out.println(item + " is even number");
            } else {
                System.out.println(item + " is odd number");
            }
        }
    }
    
   
    
    
}
