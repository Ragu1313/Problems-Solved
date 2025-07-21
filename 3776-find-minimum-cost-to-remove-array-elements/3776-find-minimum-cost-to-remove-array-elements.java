class Solution {

    public int f(int prev,int i,int nums[],int dp[][]){

        int n = nums.length;

        if(i>=n){
            if(prev<n-1)  return nums[prev];
            return 0;
        }

        if(dp[prev][i]!=-1)   return dp[prev][i];


        int maxi = Math.max(nums[prev],nums[i]);

        int res = maxi + f(i+1,i+2,nums,dp);

        if(i+1<n){
            res =  Math.min(res , Math.max(nums[i],nums[i+1]) + f(prev,i+2,nums,dp) );
            res = Math.min(res , Math.max(nums[i+1],nums[prev]) + f(i,i+2,nums,dp) );
        }

        return dp[prev][i] = res;

    }

    public int minCost(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(0,1,nums,dp);
    }
}