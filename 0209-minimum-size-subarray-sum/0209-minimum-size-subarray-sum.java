class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int dif = n+2;
        while(right<n){
            sum+=nums[right];
            while(sum>=target){
                sum-=nums[left];
                if(dif>right-left+1){
                    dif = right-left+1;
                }
                left++;
            }
            right++;
        }
        return dif==n+2?0:dif;
    }
}