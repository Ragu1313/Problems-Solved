class Solution {
    // double cnt = 0;
    public double f(int row,int col,int k,int n,double dp[][][]){
        if(row<0 || row>=n || col>=n || col<0 ) return 0;
        if(k==0){
            // cnt++;
           return 1.0;
        }
        if(dp[row][col][k]!=-1) return dp[row][col][k];
        double m1 = f(row+1,col+2,k-1,n,dp)*0.125;
        double m2 = f(row+2,col+1,k-1,n,dp)*0.125;
        double m3 = f(row+1,col-2,k-1,n,dp)*0.125;
        double m4 = f(row+2,col-1,k-1,n,dp)*0.125;

        double m5 = f(row-1,col-2,k-1,n,dp)*0.125;
        double m6 = f(row-2,col-1,k-1,n,dp)*0.125;
        double m7 = f(row-1,col+2,k-1,n,dp)*0.125;
        double m8 = f(row-2,col+1,k-1,n,dp)*0.125;

        dp[row][col][k] = (m1+m2+m3+m4+m5+m6+m7+m8);
        return dp[row][col][k];
    }
    public double knightProbability(int n, int k, int row, int col) {
        double dp[][][] = new double[101][101][k+1];
        for(double i[][]:dp){
            for(double j[]:i)
            Arrays.fill(j,-1);
        }
        double res = f(row,col,k,n,dp);
        // System.out.println(res+" "+res/cnt);
        return res;
    }
}