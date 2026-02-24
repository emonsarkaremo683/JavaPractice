
package com.ensark.genericclass;


import com.ensark.genericclass.model.Student;
import java.util.ArrayList;


public class GenericClass {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        
        list.add(new Student(1, "Emon", "emon@gmail.com"));
        list.add(new Student(2, "Jui", "jui@gmail.com"));
        list.add(new Student(3, "Badrul", "badrul@gmail.com"));
        list.add(new Student(4, "Tanvir", "tanvir@gmail.com"));
        
        System.out.println(list);
        
       
        
    }
}
