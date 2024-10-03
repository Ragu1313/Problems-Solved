class Solution {
    public int min(int i,int j,int m,int col,int matrix[][],int dp[][]){
        if(i<0 || j<0 || j>=m){
            return (int)Math.pow(10,9);
        }
        if(i==0){
            return matrix[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j] ;
        }
        int top = Integer.MAX_VALUE;
        // top = min(i-1,j-1,m,matrix,dp);
        for(int k=0;k<matrix.length;k++){
           if(k!=col)
            top = Math.min(top,min(i-1,k,m,k,matrix,dp));
        }
        return dp[i][j]=top+matrix[i][j];

    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = Integer.MAX_VALUE;
        int dp[][] = new int[n][m];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            res = Math.min(res,min(n-1,i,m,i,matrix,dp));
        }
        return res;
    }
}