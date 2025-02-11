class Solution {
public:
    int f(int i,int prev,vector<int>& nums,vector<vector<int>>&dp){
        if(i<0){
            return 0;
        }
        if(dp[i][prev]!=-1) return dp[i][prev];
        if(nums[i]<=prev){
            int l = f(i-1,nums[i],nums,dp);
            l = min(l,1+f(i-1,prev,nums,dp));
            return dp[i][prev] =  l;
        }
        else {
            return dp[i][prev] = 1 + f(i-1,prev,nums,dp); 
        }
    }
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        // for(aut)
        vector<vector<int>> dp(n,vector<int>(5,-1));
        return f(n-1,4,nums,dp);
    }
};