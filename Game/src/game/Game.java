package game;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        // Guess Game
//        Scanner s = new Scanner(System.in);
//        int randomNumber = (int) (Math.random() * 10);
//        boolean flag = true;
//        System.out.println(randomNumber);
//        System.out.println("Enter your guess Number");
//        int guessNumber = s.nextInt();
//        int chance = 3;
//      
//        while (chance > 1 && flag) {
//            if (guessNumber == randomNumber) {
//                System.out.println("You Win");
//                flag = false;
//            } else if (guessNumber > randomNumber) {
//                System.out.println("Your Guess number is higher");
//                System.out.println("Enter your guess Number");
//                guessNumber = s.nextInt();
//              
//            } else {
//                System.out.println("Your Guess number is lower");
//                System.out.println("Enter your guess Number");
//                guessNumber = s.nextInt();
//                
//            }
//
//            chance--;
//        }
//        
//        if(flag){
//            System.err.print("Better luck");
//        }

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");

        int a = s.nextInt();

        int b = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                b++;
            }
        }

        if (b == 2) {
            System.out.println(a + " is a prime number");
        } else {
            System.out.println(a + " is not a prime number");
        }
    }

}
