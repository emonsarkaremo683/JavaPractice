package game;

import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        String b = "1";
        for(int i = 1; i<=a; i++){
            for(int j = 1; j<= a-i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k<= (2 * i -1); k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    

}
