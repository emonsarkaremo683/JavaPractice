package datastructures;

import datastructures.array.DataStructureArray;
import datastructures.student.Student;
import java.util.Scanner;

public class DataStructures {

    public static void main(String[] args) {
        int[] array = {10, 20, 14, 15, 16, 18, 19, 11, 41,47};

        DataStructureArray arr = new DataStructureArray();

        System.out.println("Finding Prime Number" + arr.primeArray(array));
//
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter your Name");
//        String name = s.nextLine();
//
//        System.out.println("Enter your id");
//        int id = s.nextInt();
//
//        System.out.println("Enter your Course name");
//        String course = s.next();
//
//        System.out.println("Enter your mark");
//        int mark = s.nextInt();
//
//        Student student = new Student(id, name, course, mark);
//        System.out.println(student);
    }

}
