import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fileio{
   public static void main(String[] args) {
     try{
        BufferedWriter w = new BufferedWriter(new FileWriter("Write.txt"));
        w.write("Hi I am Ragu");
        String a[] = {"C","D","E"};
        for( String i : a){
            w.write("\n" + i);
        }
        w.close();
     }catch(IOException e){
        e.printStackTrace();
     }
     try{
        BufferedWriter wr = new BufferedWriter(new FileWriter("Demo.txt"));
        BufferedReader r = new BufferedReader(new FileReader("Write.txt"));
        // System.out.println(r.readLine());
        String line;
        while((line=r.readLine())!=null){
            System.out.println(line);
            wr.write(line+"\n");
        }
        wr.close();
        r.close();
     }catch(IOException e){
        e.printStackTrace();
     }
   }
}