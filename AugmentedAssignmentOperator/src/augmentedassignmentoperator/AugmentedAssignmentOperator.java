package augmentedassignmentoperator;

public class AugmentedAssignmentOperator {

    public static void main(String[] args) {
        int a = 5;
        a += a; // a = a + a;
        System.out.println(a);
        
        a -= 3;
        System.out.println(a);
        
        a *= 5;
        System.out.println(a);
        
        a /= 2;
        System.out.println(a);

        a %= 2;
        System.out.println(a);
        
        int i =2;
        System.out.println("a++ = " + a++);
        System.out.println("++a = " + ++a);
        System.out.println("a-- = " + a--);
        System.out.println("--a = " + --a);
        
       
        
    }

}
