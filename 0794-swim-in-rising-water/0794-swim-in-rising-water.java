class Solution {
    public int f(int i,int j,int maxi,int n,int m,int [][]grid,int dp[][][]){
        if(i<0 || i>=n || j>=m || j<0 || grid[i][j]==-1){
            return 1000000;
        }
        if(i==n-1 && j==m-1) {
            if(maxi<grid[i][j]){
                return grid[i][j];
            }
            return maxi;
        }
        if(dp[i][j][maxi]!=-1){
            return dp[i][j][maxi];
        }
        if(maxi<grid[i][j]){
            maxi = grid[i][j];
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        int top = f(i-1,j,maxi,n,m,grid,dp);
        int left = f(i,j-1,maxi,n,m,grid,dp);
        int right = f(i,j+1,maxi,n,m,grid,dp);
        int bottom = f(i+1,j,maxi,n,m,grid,dp);
        grid[i][j] = temp;
        return dp[i][j][maxi] = Math.min(top,Math.min(left,Math.min(right,bottom)));
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mul = n*m;
        int dp[][][] = new int[n][m][mul];
        for(int i[][]:dp){
            for(int j[] :i){
                Arrays.fill(j,-1);
            }
        }
        return f(0,0,grid[0][0],grid.length,grid[0].length,grid,dp);
    }
}