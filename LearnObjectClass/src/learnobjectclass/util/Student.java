package learnobjectclass.util;

import java.util.Date;

public class Student {

    public int id;
    public String name;
    public String email;
    public String phoneNumber;
    public String fatherName;
    public String motherName;
    public Date dob;
    public String course;
    public String centerName;
    public String round;

    public Student() {
    }

    public Student(int id, String name, String email, String phoneNumber, String fatherName, String motherName, Date dob, String course, String centerName, String round) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this.course = course;
        this.centerName = centerName;
        this.round = round;
    }

    public Student(int id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  "id = " + id + 
                ",\nname = " + name + 
                ",\nemail = " + email + 
                ",\nphoneNumber = " + phoneNumber;
    }
    

}
