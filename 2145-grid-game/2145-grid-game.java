class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long prefix[] = new long[n];
        long sufix[] = new long[n];
        prefix[0] = grid[1][0];
        sufix[n-1] = grid[0][n-1];
        // System.out.println(sufix[0]);
        for(int i=1;i<n;i++){
            prefix[i] +=prefix[i-1]+grid[1][i];
        }
        for(int i=n-2;i>=0;i--){
            sufix[i] +=sufix[i+1]+grid[0][i];
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(sufix[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     // System.out.print(prefix[i]+" "+i+" ");
        //     System.out.print(prefix[i]+" ");
        // }
        
        for(int i=0;i<n-1;i++){
            if(sufix[i+1]<=prefix[i]){
                if(i!=0)
                return Math.max(sufix[i+1],prefix[i-1]);
                return sufix[i+1];
            }
        }
        return prefix[n-1]-grid[1][n-1];
    }
}