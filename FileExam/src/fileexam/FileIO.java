package fileexam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FileIO {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Admin\\Desktop\\RNR.dat");

        try (FileOutputStream fos = new FileOutputStream(f)) {
            String text = "Hi buddy, i will be there for you";
            fos.write(text.getBytes());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            int a;
            while ((a = fis.read()) != -1) {
                System.out.print((char) a);
            }
            System.out.println("");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
