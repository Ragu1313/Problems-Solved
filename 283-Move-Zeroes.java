class Solution {
    public void moveZeroes(int[] nums) {
        int l1 = 0;
        int r1 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                r1++;
            }
            else{
                nums[l1++] = nums[i];
            }
        }
        
        for(int i = l1;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}