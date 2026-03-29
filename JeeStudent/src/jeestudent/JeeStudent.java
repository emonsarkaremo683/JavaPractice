package jeestudent;

//import jeestudent.view.StudentView;
public class JeeStudent {

    public static void main(String[] args) {
//        StudentView sv = new StudentView();
//        sv.setVisible(true);   

        System.out.println(lengthOfLastIndex("Hello World"));

    }

    public static int lengthOfLastIndex(String s) {

        String a = s.trim();
        String[] arr = a.split(" ");

        return arr[arr.length - 1].length();

    }

}
