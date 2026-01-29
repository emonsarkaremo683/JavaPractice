
package practicepart;

import java.util.Scanner;

public class PracticePart {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();
        
        int i = 1;
        int b = 1;
        while(i <= a){
            b *= i;
            i++;
        }
        
        System.out.println(b);
  
    }
    
}
