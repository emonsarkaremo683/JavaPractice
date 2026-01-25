
package javaapplication3;

import java.util.Scanner;


public class JavaApplication3 {

   
    public static void main(String[] args) {
//        System.out.println("Enter times:");
//        Scanner s = new Scanner(System.in);
//        
//        for(int i = 0; i < s.nextInt(); i++){
//            System.out.println("Enter value");
//            
//            
//            
//            
//        }

    Scanner s = new Scanner(System.in);
        System.out.println("Enter a value");
    int a = s.nextInt();
    int d = a / 3600;
        a = a % 3600; 
    int b= a / 60;
    int c = a % 60;
    
        System.out.println( d + " Hour "+ b + " Minute " + c + " Second");
    }

    
}
