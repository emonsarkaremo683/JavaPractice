package practicepart;

import java.util.Arrays;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        String set1
                = "1 3 5 7\n "
                + "9 11 13 15\n "
                + "17 19 21 23\n "
                + "25 27 29 31";

        String set2
                = "2 3 6 7\n "
                + "10 11 14 15\n "
                + "18 19 22 23\n "
                + "26 27 30 31";

        String set3
                = "4 5 6 7\n "
                + "12 13 14 15\n "
                + "20 21 22 23\n "
                + "28 29 30 31";

        String set4
                = "8 9 10 11\n "
                + " 12 13 14 15\n "
                + " 24 25 26 27\n "
                + " 28 29 30 31";

        String set5
                = "16 17 18 19\n "
                + " 20 21 22 23\n "
                + " 24 25 26 27\n "
                + " 28 29 30 31";

        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Is your Birthday in Set1? if yes enter 1, no 0");
        System.out.println(set1);
        
        int a = s.nextInt();
        int sum = 0;
        sum += dateCount(a, set1);
        
        System.out.println("Is your Birthday in Set2? if yes enter 1, no 0");
        System.out.println(set2);
        
        a = s.nextInt();      
        sum += dateCount(a, set2);
       
        System.out.println("Is your Birthday in Set3? if yes enter 1, no 0");
        System.out.println(set3);        
        a = s.nextInt();      
        sum += dateCount(a, set3);
        
        System.out.println("Is your Birthday in Set4? if yes enter 1, no 0");
        System.out.println(set4);        
        a = s.nextInt();      
        sum += dateCount(a, set4);
        
        System.out.println("Is your Birthday in Set5? if yes enter 1, no 0");
        System.out.println(set5);        
        a = s.nextInt();      
        sum += dateCount(a, set5);
        
        System.out.println("your birthday is " + sum);
       

    }

    static int dateCount(int a, String s) {
        String[] details = s.split(" ");
        int b = 0;
        if(a == 1)
             b =Integer.parseInt(details[0]);
        
        return b;
    }
    
    

}
