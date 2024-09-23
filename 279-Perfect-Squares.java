class Solution {
    public int min(int n,int num,int dp[][]){
        if(num==1){
            return n/num;
        }
        if(n==0)
            return 0;
        if(dp[num][n]!=-1)
            return dp[num][n];
        int pick = Integer.MAX_VALUE;
        int notpick = min(n,num-1,dp);
        if(num*num<=n){
            pick =1+ min(n-num*num,num,dp);
        }
        return dp[num][n] = Math.min(pick,notpick);
    }
    public int numSquares(int n) {
        int num = (int) Math.sqrt(n);
        int dp[][] = new int[num+1][n+1];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return min(n,num,dp);
    }
}