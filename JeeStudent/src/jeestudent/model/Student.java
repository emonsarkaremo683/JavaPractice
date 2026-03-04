
package jeestudent.model;

import java.util.Date;


public class Student {
    
    int id;
    String name;
    String email;
    Date dob;
    String courseName;

    public Student() {
    }

    public Student(String name, String email, Date dob, String courseName) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.courseName = courseName;
    }

    public Student(String name, String email, String courseName) {
        this.name = name;
        this.email = email;
        this.courseName = courseName;
    }

    public Student(int id, String name, String email, Date dob, String courseName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.courseName = courseName;
    }

    public Student(int id, String name, String email, String courseName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseName = courseName;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", courseName=" + courseName + '}';
    }
    
    
    
    
}
