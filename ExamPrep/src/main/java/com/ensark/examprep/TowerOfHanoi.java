
package com.ensark.examprep;


public class TowerOfHanoi {

    
    public static void main(String[] args) {
        solveHanoi(5, 'A', 'B', 'C');
       
    }
    
   
    // Recursive function to solve Tower of Hanoi
    static void solveHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
       
        solveHanoi(n - 1, source, auxiliary, destination);
      
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        // Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxiliary, destination, source);
    }
    
}
