class Solution {
    public int removeDuplicates(int[] nums) {
        int i;
        int c=0;
        int len = nums.length;
        for(i=0;i<len-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[c]=nums[i];
                c++;
            }
        }
        nums[c]=nums[len-1];
        c++;
        return c;
        
    }
}