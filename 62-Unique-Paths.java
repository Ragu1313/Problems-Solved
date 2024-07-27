class Solution {
    // public int unique(int i,int j,int dp[][]){
    //     if(i<0 || j<0)
    //         return 0;
    //     if(i==0 && j==0)
    //         return 1;
    //     if(dp[i][j]!=-1)
    //         return dp[i][j];
    //     int top = unique(i-1,j,dp);
    //     int left = unique(i,j-1,dp);
    //     return dp[i][j]=top+left;
    // }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        for(int []i:dp)
            Arrays.fill(i,-1);
        int i,j;
        int top,left;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(j==0 && i==0){
                    dp[i][j] = 1;
                    continue;
                }
                top=0;
                left=0;
                if(i>0)
                    top = dp[i-1][j];
                if(j>0)
                    left = dp[i][j-1];
                
                dp[i][j]=top+left;
            }
        }
        return dp[m-1][n-1];
    }
}