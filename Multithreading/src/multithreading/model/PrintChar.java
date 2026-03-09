
package multithreading.model;


public class PrintChar implements Runnable{
    
    char charToPrint;
    int times;

    public PrintChar() {
    }

    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }
    
    

    @Override
    public void run() {
        for(int i = 0; i < times; i++){
            System.out.print(charToPrint + " ");
        
        }


    }
    
}
