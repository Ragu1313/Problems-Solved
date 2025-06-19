class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-prev>k){
                res++;
                prev = nums[i];
            }
        }
        return res+1;
    }
}