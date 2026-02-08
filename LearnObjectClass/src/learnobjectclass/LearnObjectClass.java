
package learnobjectclass;

import learnobjectclass.geometry.Circle;
import learnobjectclass.geometry.RectAngle;
import learnobjectclass.util.Student;

public class LearnObjectClass {

    public static void main(String[] args) {
        
        Circle circle = new Circle(15);
        
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        
        
        RectAngle angle = new RectAngle();
        angle.height = 10;
        angle.width = 8;        
        System.out.println(angle.getArea());
        System.out.println(angle.getPerimeter());    
        
        
        Student s = new Student(1,
                "Emon Sarkar",
                "emonsarkar.emo683@gmail.com",
                "01531767051");
        
        System.out.println(s);
    }
    
}
