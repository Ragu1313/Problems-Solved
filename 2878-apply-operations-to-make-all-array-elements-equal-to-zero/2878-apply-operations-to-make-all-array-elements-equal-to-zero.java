class Solution {
    public boolean checkArray(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i]-=sum;
            sum+=nums[i];
            if(i>=k-1){
                sum-=nums[i-k+1];
            }
            if(nums[i]<0)   return false;
        }
        // System.out.println(sum);
        return sum==0;
    }
}