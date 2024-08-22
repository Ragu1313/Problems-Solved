class Solution {
    public static int get(int i,int flag,int n,int[] values,int dp[][]){
        if(i>n)
            return 0;
        if(dp[i][flag]!=-1)
            return dp[i][flag];
        int take=0;
        if(flag==1)
            take = Math.max(get(i+1,0,n,values,dp)-values[i],get(i+1,1,n,values,dp));
        else    
            take = Math.max(get(i+1,1,n,values,dp)+values[i],get(i+1,0,n,values,dp));
        return dp[i][flag] = take;
    }

    public int maxProfit(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][2];
        for(int i[] : dp)
            Arrays.fill(i,-1);
        return get(0,1,n-1,values,dp);
    }
}