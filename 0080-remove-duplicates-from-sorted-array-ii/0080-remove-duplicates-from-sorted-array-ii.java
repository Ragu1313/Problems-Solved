class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 2;
        int prev = nums[1];
        int second = nums[0];
        int i = 2;
        while(i<n){
            if(prev!=nums[i] || nums[i]!=second){
                second = prev;
                prev = nums[i];
                nums[k++] = nums[i];
            }
            i++;
        }

        return k;
    }
}