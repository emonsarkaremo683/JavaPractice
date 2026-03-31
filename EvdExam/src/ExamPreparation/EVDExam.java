
package ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EVDExam {

    
    public static void main(String[] args) {
       int[][] array = {
           {1,99,91,11,44},
           {0,10,9,9,11},
           {3,23,21,5,20},
           {13,4,45,66,33},
           {11,0,1,20,56}
       };
        twoDimensionalArray(array);
        
        
        System.out.println(factorial(5));
        
        List<Integer> list = new ArrayList<>();
        
       for(int i = 1; i<=10; i++){
           list.add(i);
       }
       
        System.out.println(list);
    }
    
    static void twoDimensionalArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            array[i] = bubbleSort(array[i]);
           
        }
        
        System.out.println(Arrays.deepToString(array));
    
    }
    
    static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        
        return array;
    
    }
    
    static int maxNumber(int[] array){
    
        return Arrays.stream(array).max().getAsInt();
    }
    
    static int minNumber(int[] array){
    
        return Arrays.stream(array).min().getAsInt();
    }
    
    
    static int factorial(int n){
        if (n <= 1) {
            return 1;
        }else {
            return n * factorial(n - 1);
        }
        
    }
    
}
