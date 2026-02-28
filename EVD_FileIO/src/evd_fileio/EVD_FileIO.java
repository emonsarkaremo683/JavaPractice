package evd_fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVD_FileIO {

    public static void main(String[] args) {
        String path = ".\\RRR.dat";
        create(path);
        write(path);
        read(path);
    }

    static void write(String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {

            for (int i = 1; i <= 20; i++) {
                fos.write(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EVD_FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EVD_FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void read(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            int value;
            while ((value = fis.read()) != -1) {
                System.out.print(value + " ");
            }
            System.out.println("");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EVD_FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EVD_FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void create(String path) {
        File f = new File(path);
        try {
            if (!f.exists()) {
                boolean createNewFile = f.createNewFile();
                System.out.println("Created");
            } else {
            }
        } catch (IOException ex) {
            Logger.getLogger(EVD_FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
