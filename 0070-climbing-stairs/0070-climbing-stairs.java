class Solution {
    public int f(int i,int n,int dp[]){
        if(i==n)    return 1;
        if(i>n) return 0;
        if(dp[i]!=-1)   return dp[i];
        return dp[i] = f(i+1,n,dp) + f(i+2,n,dp);
    }
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // dp[0] = dp[1]=1;
        return f(0,n,dp);
    }
}