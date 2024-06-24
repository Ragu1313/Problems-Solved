import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        System.out.println("Executed Successfully");
        try (Scanner input = new Scanner(System.in)) {
            String a = input.next();
            String b= input.next();
            String c = input.next();
            String d = input.next();
            String e = input.next();
            System.out.println(a+b+c+d+e);
        }
    }

    
}
