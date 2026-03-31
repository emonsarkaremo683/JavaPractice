package ExamPreparation.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryIO {

    public static void main(String[] args) {
        File f = new File("Evidence.dat");

        try {
            FileOutputStream fos = new FileOutputStream(f);

            for (int i = 1; i <= 10; i++) {
                fos.write(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            FileInputStream fis = new FileInputStream(f);
            
            int result;
            
            while((result = fis.read()) != -1){
                
                System.out.println(result);
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
