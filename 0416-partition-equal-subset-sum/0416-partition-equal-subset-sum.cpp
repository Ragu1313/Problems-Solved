class Solution {
public:
    int solve(vector<int>& nums, vector<vector<int>>& dp, int s, int idx,
               int t) {
        if (idx >= nums.size() || s > t)
            return 0;
        if (t == s )
            return 1;
        if(dp[idx][s]!=-1)  return dp[idx][s];
        int res=0;
        if(solve(nums, dp, s + nums[idx], idx + 1, t) || solve(nums, dp, s, idx + 1, t)){
            res = 1;
        }
        return dp[idx][s] = res;
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
        return solve(nums, dp, 0, 0, sum);
       
    }
};