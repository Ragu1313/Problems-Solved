import java.util.Scanner;

public class Demogreedy{
    public static boolean greedy(int []arr,int l){
        int m=0;
        int i;
        for(i=0;i<l;i++){
            if(m<i)
               return false;
            else{
                if(m<arr[i]+i){
                    m = arr[i]+i;
                }                
            }
        }
        if(m>=i-1)
        return true;
        else 
          return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = s.nextInt();
        int i;
        int arr[] = new int[n];
        for(i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(greedy(arr,n));
    }
}