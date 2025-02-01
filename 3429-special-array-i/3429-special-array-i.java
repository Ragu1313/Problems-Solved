class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if((nums[i]&1)==1)
                nums[i] = 1;
            else{
                nums[i] = 0;
            }
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                return false;
            }
        }
        return true;
    }
}