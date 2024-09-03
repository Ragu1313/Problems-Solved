class Solution {
    public int maxi(int i,int flag,int n,int prices[],int fee,int dp[][]){
        if(i>n){
            return 0;
        }
        if(dp[i][flag]!=-1)
            return dp[i][flag];
        int val;
        if(flag==0){
            val = Math.max(maxi(i+1,1,n,prices,fee,dp)-prices[i],maxi(i+1,0,n,prices,fee,dp));
        }
        else{
            val = Math.max(maxi(i+1,0,n,prices,fee,dp)+prices[i]-fee,maxi(i+1,1,n,prices,fee,dp));
        }
        return dp[i][flag] = val;
    }
    public int maxProfit(int[] prices, int fee) {
        int [][] dp = new int [prices.length][2];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return maxi(0,0,prices.length-1,prices,fee,dp);
    }
}