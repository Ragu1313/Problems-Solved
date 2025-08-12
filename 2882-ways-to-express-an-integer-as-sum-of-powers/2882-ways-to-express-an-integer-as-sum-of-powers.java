class Solution {
    
    int mod = (int)(1e9+7);

    public int f(int n,int start , int x,int dp[][]){
        
        if(n==0)  return 1;

        if(n<0 || start<=0) return 0;

        if(dp[n][start]!=-1)  return dp[n][start];

        long res = f(n,start-1,x,dp) % mod;

        int temp = (int)(Math.pow(start,x));

        if(temp<=n){
            res = (res + f(n-temp,start-1,x,dp)) % mod;
        }

        return dp[n][start] =(int) res ;

    }
    public int numberOfWays(int n, int x) {
        int dp[][] = new int[n+1][301];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(n,n,x,dp);
    }
}