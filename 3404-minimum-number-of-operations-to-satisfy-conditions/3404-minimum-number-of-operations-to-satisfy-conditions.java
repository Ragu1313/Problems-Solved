class Solution {
    public int f(int col,int prev,int grid[][],int dp[][]){
        if(col==grid[0].length) return 0;
        int steps = Integer.MAX_VALUE;
        if(dp[col][prev+1]!=-1) return dp[col][prev+1];
        for(int k=0;k<=9;k++){
            int temp = 0;
            if(prev==k) continue;
            for(int i=0;i<grid.length;i++){
                if(grid[i][col]!=k){
                    temp++;
                }
            }
            steps = Math.min(steps,temp+f(col+1,k,grid,dp));
        }
        return dp[col][prev+1] = steps; 
        
    }
    public int minimumOperations(int[][] grid) {
        int col = grid[0].length;
        int dp[][] = new int[col][11];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(0,-1,grid,dp);
    }
}