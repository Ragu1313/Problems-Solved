class Solution {
    public boolean can(int i,int target,int[] nums,int [][]dp){
        if(target==0)
            return true;
        if(i==0){
            if(target==nums[0])
                return true;
            else
                return false;
        }
        if(dp[i][target]!=-1)
            return dp[i][target]==1;
        boolean nottake = can(i-1,target,nums,dp);
        boolean take = false;
        if(nums[i]<=target)
            take = can(i-1,target-nums[i],nums,dp);
        if(take || nottake )
            dp[i][target] = 1;
        else
            dp[i][target] = 0;
        return take || nottake;

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2==1)
            return false;
        int dp[][] = new int[nums.length][sum/2+1];
        for(int [] i:dp)
            Arrays.fill(i,-1);
        return can(nums.length-1,sum/2,nums,dp);
        

    }
}