class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
       int pre[] = new int[n];
       int suf[] = new int[n];
       pre[0] = nums[0];
       suf[n-1] = nums[n-1];
       long res = 0;
       for(int i=1;i<n;i++){
           pre[i] = Math.max(nums[i],pre[i-1]);
       }
       for(int i=n-2;i>=0;i--){
            suf[i] = Math.max(suf[i+1],nums[i]);
       }
       for(int i=1;i<n-1;i++){
         res = Math.max(res,(pre[i-1]-nums[i])*1L*suf[i+1]);
       }
       return res;
    }
}