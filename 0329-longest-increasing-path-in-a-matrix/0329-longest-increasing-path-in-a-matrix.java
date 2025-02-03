class Solution {
    public int f(int i,int j,int mat[][],int vis[][],int n,int m,int dp[][]){
        // if(i<0 || i>=n || j<0 || j>=m || vis[i][j]==1){
        //     return 0;
        // }
        if(dp[i][j]!=1 ){
            return dp[i][j];
        }
        if(vis[i][j]==1 && dp[i][j]==1){
            return 1;
        }
        vis[i][j] = 1;
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        if(i+1>=0 && i+1<n &&  mat[i+1][j]>mat[i][j]){
            top = 1+f(i+1,j,mat,vis,n,m,dp);
        }
        if(i-1>=0 && i-1<n &&  mat[i-1][j]>mat[i][j]){
            bottom = 1+f(i-1,j,mat,vis,n,m,dp);
        }
        if(j+1>=0 && j+1<m &&  mat[i][j+1]>mat[i][j]){
            right = 1+f(i,j+1,mat,vis,n,m,dp);
        }
        if(j-1>=0 && j-1<m &&  mat[i][j-1]>mat[i][j]){
            left = 1+f(i,j-1,mat,vis,n,m,dp);
        }

        return dp[i][j] = Math.max(left,Math.max(right,Math.max(top,Math.max(1,bottom))));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int grid[][] = new int[n][m];
        for(int i[] : grid){
            Arrays.fill(i,1);
        }
        // for(int i=0)
        int vis[][] = new int[n][m];
        int res = 1;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    res = Math.max(res,f(i,j,matrix,vis,n,m,grid));
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
}