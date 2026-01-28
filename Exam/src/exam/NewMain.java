/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NewMain {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        int a = s.nextInt();
//        
//        if(a%2 == 0){
//            System.out.println("Even");
//       } else {
//        System.out.println("Odd");
//        }
        System.out.println("Enter first value");
        int a = s.nextInt();
        System.out.println("Enter Second value");
        int b = s.nextInt();
        System.out.println("Enter Operator");
        String c = s.next();
        
        if(c.equals("+")){
            a += b;
        } else if(c.equals("-")){
            a -= b;
        } else if(c.equals("*")){
            a *= b;
        } else{
        a /= b;
        }
        
        System.out.println(a);
        

    }

}
