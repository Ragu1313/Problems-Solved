class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int res = 0;
        while(l<r){
            int temp = nums[l]+nums[r];
            if(temp==k){
                l++;r--;
                res++;
            }
            else if(temp<k){
                l++;
            }
            else{
                r--;
            }
        }
        // if(nums[l]==k){
        //     res++;
        // }
        return res;
    }
}