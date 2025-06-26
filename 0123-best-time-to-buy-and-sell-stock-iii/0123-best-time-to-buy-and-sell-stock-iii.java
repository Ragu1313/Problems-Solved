class Solution {

    public int f(int i,int flag,int k,int n,int arr[],int dp[][][]){
        
        if(k==0) return 0;

        if(i==n)  return 0;

        if(dp[i][flag][k]!=-1)  return dp[i][flag][k];

        int sum = f(i+1,flag,k,n,arr,dp);
        if(flag == 0){
            sum = Math.max(sum,f(i+1,1,k,n,arr,dp)-arr[i]);
        }
        else {
            sum = Math.max(sum,f(i+1,0,k-1,n,arr,dp)+arr[i]);
        }
        return dp[i][flag][k] = sum;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return f(0,0,2,n,prices,dp);
    }
}