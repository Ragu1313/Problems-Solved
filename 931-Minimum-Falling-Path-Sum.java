class Solution {
    public int min(int i,int j,int m,int matrix[][],int dp[][]){
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
        top = min(i-1,j-1,m,matrix,dp);
        top = Math.min(top,Math.min(min(i-1,j,m,matrix,dp),min(i-1,j+1,m,matrix,dp)));
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
            res = Math.min(res,min(n-1,i,m,matrix,dp));
        }
        return res;
    }
}