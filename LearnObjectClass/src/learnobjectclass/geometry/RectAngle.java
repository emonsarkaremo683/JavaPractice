
package learnobjectclass.geometry;

public class RectAngle {
    
    public double height;
    public double width;
    
    public double getArea(){
        return height * width;
    }
    
    public  double getPerimeter(){
        return 2 * (height + width);
    }
    
}
