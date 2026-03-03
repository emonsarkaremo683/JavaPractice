package fileexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileExam {

    public static void main(String[] args) {

        File f = new File("C:\\Users\\Admin\\Desktop\\Emon.dat");

        try {
            PrintWriter pw = new PrintWriter(f);
            pw.print("Hi Buddy, this");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileExam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Scanner s = new Scanner(f);
            System.out.println(s.nextLine());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileExam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
