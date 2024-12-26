class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int offset = 1000; // To handle negative indices
        int[][] dp = new int[n][2001]; // dp[i][target] where target is shifted by offset
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE); // Use MIN_VALUE to indicate uncomputed states
        }
        return f(n - 1, target, nums, dp, offset);
    }

    private int f(int i, int target, int[] nums, int[][] dp, int offset) {
        if (i < 0) {
            return (target == 0) ? 1 : 0;
        }
        if (target + offset < 0 || target + offset > 2000) {
            return 0; // Out of bounds
        }
        if (dp[i][target + offset] != Integer.MIN_VALUE) {
            return dp[i][target + offset]; // Return cached result
        }
        int sub = f(i - 1, target - nums[i], nums, dp, offset);
        int add = f(i - 1, target + nums[i], nums, dp, offset);
        dp[i][target + offset] = sub + add;
        return dp[i][target + offset];
    }
}
