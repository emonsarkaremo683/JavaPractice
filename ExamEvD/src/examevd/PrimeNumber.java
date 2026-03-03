package examevd;

import java.util.Scanner;

public class PrimeNumber {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number to check prime");
        int input = s.nextInt();
        checkPrime(input);
        
    }
    
    static void checkPrime(int n) {
        int count = 0;
        
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        
        if (count <= 2) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
        
    }
    
}
