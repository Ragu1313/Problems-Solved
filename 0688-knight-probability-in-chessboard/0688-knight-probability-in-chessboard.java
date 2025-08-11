class Solution {
    int dir[][] = {
        {-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}
    };
    public double f(int k,int row,int col,int n,double dp[][][]){
        if(row<0 || col<0 || row>=n || col>=n)  return 0.0;
        if(k==0) {
            return 1;
        }
        if(dp[k][row][col]!=-1)  return dp[k][row][col];
        double res = 0.0;
        for(int i=0;i<8;i++){
            res += (f(k-1,row+dir[i][0],col+dir[i][1],n,dp)*0.125);
        }
        return dp[k][row][col] = res;
    }
    public double knightProbability(int n, int k, int row, int col) {
        double dp[][][] = new double[k+1][n][n];
        for(double i[][] : dp){
            for(double j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return f(k,row,col,n,dp);
    }
}