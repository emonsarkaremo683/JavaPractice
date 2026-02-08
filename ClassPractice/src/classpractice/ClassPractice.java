
package classpractice;

import classpractice.calculation.Calculation;


public class ClassPractice {

   
    public static void main(String[] args) {
        Calculation c = new Calculation();
        
        System.out.println(c.priceCalculation(15,10));
        System.out.println(c.priceCalculation(150,10));
        System.out.println(c.priceCalculation(25,10));
    }
    
}
