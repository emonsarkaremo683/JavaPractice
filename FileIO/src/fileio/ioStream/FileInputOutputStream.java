package fileio.ioStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileInputOutputStream {

    public static void main(String[] args) {
        File file = new File("Emon.txt");

        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Write text into a file without auto close
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String s = "I'm in Love with FairyTale\nEven though it hurts\nCause i don't care \nif i lose my mind\nI'm already cursed!\n";
            fos.write(s.getBytes());
            fos.close();

        } catch (IOException ex) {
            Logger.getLogger(FileInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Read file without auto close
        try {
            FileInputStream fis = new FileInputStream(file);
            int i = fis.read();

            while (i != -1) {
                System.out.print((char) i);
                i = fis.read();
            }
            System.out.println("");

        } catch (IOException ex) {
            Logger.getLogger(FileInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }

}
