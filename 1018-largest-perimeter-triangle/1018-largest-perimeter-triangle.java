class Solution {
    
    public int largestPerimeter(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-3;i>=0;i--){
            if(nums[i] + nums[i+1] > nums[i+2]){
                res = nums[i] + nums[i+1] + nums[i+2];
                return res;
            }
        }
        return res;
    }
}