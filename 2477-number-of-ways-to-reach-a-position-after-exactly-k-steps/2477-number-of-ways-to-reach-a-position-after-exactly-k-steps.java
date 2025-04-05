class Solution {
    // int res = 0;
    int mod = (int)(1e9+7);
    public long f(int i,int j,int endpos,long dp[][]){
        if(j==0){
            if (i==endpos)  return 1;
            return 0;
        }
        if(Math.abs(i-endpos)>j)    return 0;
        if(j<0 )  return 0;
        if (dp[i+1000][j] != -1) return dp[i+1000][j]%mod;
        long inc = f(i+1,j-1,endpos,dp)%mod;
        long dec = f(i-1,j-1,endpos,dp)%mod;
        dp[i+1000][j] = (inc+dec)%mod;
        return dp[i+1000][j]%mod;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int maxi = Math.max(startPos,endPos);
        long dp[][] = new long[3001][k+1];
        for(long i[]: dp){
            Arrays.fill(i,-1);
        }
        return (int)f(startPos,k,endPos,dp);
    }
}