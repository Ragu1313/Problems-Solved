class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // int offset = 1000; 
        int[][] dp = new int[n][2001];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE); 
        }
        return f(n - 1, target, nums, dp);
    }

    private int f(int i, int target, int[] nums, int[][] dp) {
        if(i<0){
            return target==0?1:0;
        }
        if(target+1000<0 || target+1000>2000){
            return 0;
        }
        if(dp[i][target+1000]!=Integer.MIN_VALUE){ 
            return dp[i][target+1000];
        }
        int left = f(i-1,target-nums[i],nums,dp);
        int right = f(i-1,target+nums[i],nums,dp);
        return dp[i][target+1000] = left+right;
    }
}
