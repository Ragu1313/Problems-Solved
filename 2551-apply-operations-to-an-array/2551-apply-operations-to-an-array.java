class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        int l = 0;
        int r = 0;
        while(r<n){
            while(l<n &&nums[l]!=0){
                l++;
            }
            r = l;
            while(r<n && nums[r]==0){
                r++;
            }
            if(r<n){
                nums[l] = nums[r];
                nums[r] = 0;
            }
            l++;r++;
        }
        return nums;
    }
}