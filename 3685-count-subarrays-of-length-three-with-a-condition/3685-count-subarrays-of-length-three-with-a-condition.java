class Solution {
    public int countSubarrays(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length-2;i++){
            int f = nums[i];
            int s = nums[i+1];
            int t = nums[i+2];
            if((f+t)<<1==s)
                res++;
        }
        return res;
    }
}