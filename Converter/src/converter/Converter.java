
package converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Converter {


    public static void main(String[] args) {
         String[] arr = { "Java", "Python", "C++" };
         
         ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
         
         list.remove(1);
         
         System.out.println(list);
    
    }
    
}
