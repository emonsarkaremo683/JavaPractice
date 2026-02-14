package fileio.ioStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileBufferMethod {

    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Emons.txt", true))) {
            bw.write("I'm in Love with FairyTale");
            bw.newLine();
            bw.write("Even though it hurts");
            bw.newLine();
            bw.write("cause i don't care if i lose my mind");
            bw.newLine();
            bw.write("I'm already cursed!");
        } catch (IOException ex) {
            Logger.getLogger(FileBufferMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Emon.txt"));
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
