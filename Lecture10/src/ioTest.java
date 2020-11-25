import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class ioTest {

    public static void main(String [] args){
        //FileInputStream fis = new FileInputStream("filename.txt");
        // .read() - reads 1 byte at a time

        //FileReader fr = new FileReader("filename.txt");
        // .read()  - reads 2 byte / 1 char at a time
        // .readline() - reads the whole line

        //BufferedReader br = new BufferedReader(fr);
        // good practice
        // .readline() - read teh whole line from console.
    }
}
