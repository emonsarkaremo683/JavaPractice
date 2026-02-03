package practicepart.arraysubclass;

import java.util.Scanner;
import java.util.Arrays;

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
        for (int item : myArray) {
            sum += item;
        }

        System.out.println("Average number of array " + (double) (sum / myArray.length));
    }

    public void oddEvenNumber(int[] myArray) {

        for (int item : myArray) {
            if (item % 2 == 0) {
                System.out.println(item + " is even number");
            } else {
                System.out.println(item + " is odd number");
            }
        }
    }

    public void findPrimeNumber(int[] myArray) {

        int i = 0;
        for (int item : myArray) {
<<<<<<< Updated upstream
            if(isPrime(item)){
                System.out.println(item + " is a prime number");
=======
            for (int j = 1; j <= myArray.length; j++) {
                if (item % j == 0) {
                    i++;
                }               
            }
            System.out.println(findPrimeNumber(i, item));
>>>>>>> Stashed changes

            } else {
                System.out.println(item + " is not a prime number");
            }
        }
            
            
    }

    
    
    private boolean isPrime(int item){
        int c = 0;
        
        for(int i = 1; i<= item; i++){
            if(item % i == 0){
                c++;
            }

        }

        if(c <= 2){
            c = 0;
            return true;
    
        } else{
            c = 0;
            return false;
        }

    }


    public void arrayPrime(int[] array){
        
        
         int i = 0;
        for(int item : array) {
            if(isPrime(item)){
                i++;
            }
        }
        
        System.out.println(Arrays.toString(newArray(i, array)));
        
    }
    
     
    
    public int[] newArray(int p, int[] array){
        int[] primeArray = new int[p];
        int i = 0;
        for(int item : array){
            if(isPrime(item)){
                primeArray[i] = item;
                i++;
            }
        }
        
        
        return primeArray;
    }
}
