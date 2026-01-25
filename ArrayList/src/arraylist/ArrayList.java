
package arraylist;

import java.util.Arrays;
import java.util.List;


public class ArrayList {

   
    public static void main(String[] args) {
       List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
       
       for(int x : numbers ) {
         System.out.print( x );
         System.out.print(",");
      }
    }
    
}
