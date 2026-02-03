
package datastructures.student;



public class Student {
    
    int id;
    String name;
    String course;
    int mark;

    public Student(int id, String name, String course, int mark) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mark = mark;
    }
    
    private String setName(String name){
        return this.name = name;
    }
    public String getName(){
        return name;
    }
    public String setCourse(String course){
        return this.course = course;
    }
    public String getCourse(){
        return course;
    }
    
    public int setId(int id){
        return this.id = id;
    }
    public int getId(){
        return id;
    }
    public int setMark(int mark){
        return this.mark = mark;
    }
    public int getMark(){
        return mark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", course=").append(course);
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }

       
}
