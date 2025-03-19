class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            // System.out.println(i);
            if(nums[i]==0){
                nums[i] = 1;
                nums[i+1] = 1-nums[i+1];
                nums[i+2] = 1-nums[i+2]; 
                cnt++;
            }
        }
        for(int i : nums){
            // System.out.print(i+" ");
            if(i==0)    return -1;

        }
        return cnt;
    }
}