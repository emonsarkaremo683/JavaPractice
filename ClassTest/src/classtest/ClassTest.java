
package classtest;

import classtest.supclass.Truck;


public class ClassTest {

   
    public static void main(String[] args) {
        
        
        Truck t = new Truck();
        
        t.setWeight(2500);
        t.setRegularPrice(1500);
        
        System.out.println(t.getSalePrice());
    }
    
}
