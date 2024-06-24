import java.util.ArrayList;

public class Twodlist{
    
    public static ArrayList<ArrayList<Integer>> pascal(int n){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int i,j;
        for(i=0;i<n;i++){
            ArrayList<Integer> b = new ArrayList<>();
            for(j=0;j<=i;j++){
                if(j==0 || j==i){
                    b.add(1);
                }
                else{
                    b.add(a.get(i-1).get(j-1)+a.get(i-1).get(j));
                }
            }
            a.add(b);
        }
        System.out.println(a.toString());

        return a; 
    }
    public static int[][] pascalTriangle(int number){
       int a[][] = new int[number][];
       int i,j;
       for(i=0;i<number;i++){
        a[i] = new int[i + 1]; 
        for(j=0;j<=i;j++){
            if(j==0 || i==j){
                a[i][j] = 1;
            }
            else{
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
       }
       for(i=0;i<number;i++){
        for(j=0;j<=i;j++){
            System.out.print(a[i][j]+ " ");
        }
        System.out.println();
       }
       return a; 
    }
    public static void main(String[] args) {
        pascalTriangle(5);
        pascal(5);
    }
}