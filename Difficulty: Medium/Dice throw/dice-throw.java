class Solution {
    static int no(int m,int n,int x,int dp[][][]){
        if(x==0 && n==0){
            return 1;
        }
        if(n==0)    return 0;
        if(dp[m][n][x]!=-1)     return dp[m][n][x];
        int tot = 0;
        for(int i=1;i<=m;i++){
            if(x-i>=0)
            tot += no(m,n-1,x-i,dp);
        }
        return dp[m][n][x] = tot;
    }
    
    static int noOfWays(int m, int n, int x) {
        int dp[][][] = new int[m+1][n+1][x+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return no(m,n,x,dp);
    }
};