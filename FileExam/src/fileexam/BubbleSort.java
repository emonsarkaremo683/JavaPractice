package fileexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[5];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Input Number");
            array[i] = s.nextInt();
        }
        bubbleSort(array);
    }

    static void bubbleSort(int[] array) {
        int[] arrays = array;
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;

                }

            }

        }
        System.out.println(Arrays.toString(arrays));
        
        
        
        
    }

}
