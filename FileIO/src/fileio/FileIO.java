package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\Desktop\\Emon.txt");
        
        //File Create
        try {
           file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Text write into a file with close

        try (PrintWriter pw = new PrintWriter(file)) {

            for(int i = 1; i <= 100; i++){
                pw.println(i);
            }
            

        } catch (FileNotFoundException e) {

        }
        
        //file reader method with auto close
        try (Scanner read = new Scanner(file)){
            

            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        // file delete
//        boolean delete = file.delete();
//        if(delete){
//            System.out.println("Deleted");
//        }
        

    }

}
