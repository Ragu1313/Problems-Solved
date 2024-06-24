import java.util.*;
class Sample{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n,i;
            n = input.nextInt();
            for(i=0;i<n;i++){
                System.out.println(i);
                
            }
      input.close();
        }
         
    }
}