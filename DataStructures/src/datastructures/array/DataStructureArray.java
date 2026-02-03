package datastructures.array;

import java.util.ArrayList;

public class DataStructureArray {

    public DataStructureArray() {
    }

    public ArrayList<Integer> primeArray(int[] array) {
        
        ArrayList<Integer> arrays = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(isPrime(array[i])) arrays.add(array[i]);
        }        
        return arrays;
    }

    
    
    private boolean isPrime(int item) {
        int c = 0;
        for (int j = 1; j <= item; j++) {
            if (item % j == 0) {
                c++;
            }
        }      
        return c <= 2;

    }

}
