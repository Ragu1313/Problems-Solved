class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int prefix = 0;
        // int maxi = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            prefix+=nums[i];
        }
        double maxi = prefix;
        for(int i=k;i<nums.length;i++){
            prefix = prefix+nums[i]-nums[i-k];
            maxi = Math.max(maxi,prefix);
        }
        return maxi/k;
    }
}