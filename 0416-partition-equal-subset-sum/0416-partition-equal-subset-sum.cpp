class Solution {
public:
    int solve(int ind,int sum,vector<int>&nums,vector<vector<int>> & dp) {
        if(ind==nums.size())    return 0;
        if(sum==0)  return 1;
        if(dp[ind][sum]!=-1)    return dp[ind][sum];
        int res = 0;
        if(nums[ind]<=sum){
            res = solve(ind+1,sum-nums[ind],nums,dp);
        }
        int res2 = solve(ind+1,sum,nums,dp);
        if(res==1 || res2==1){
            return dp[ind][sum] =  1;
        }
        return dp[ind][sum] =  0;
    }
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        int ss = nums.size();
        for (int i : nums)
            sum += i;

        if ((sum & 1))
            return false;
        sum /= 2;
        vector<vector<int>> dp(ss, vector<int>(sum + 1, -1));
        // int arr[][] = new int[n+1][sum+1];
        return solve(0,sum,nums,dp);
       
    }
};