class Solution {
    public long countSubarrays(int[] nums, int mink, int maxk) {
        long res =  0;
        int left = -1;
        int minind = 0;
        int minval = -1;
        int maxval = -1;
        int maxind = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<mink || nums[i]>maxk){
                minind = maxind = minval = maxval = -1;
            }
            else{
                if(minval==-1 && maxval==-1){
                    left = i-1;
                }
                if(minval==-1 || minval>=nums[i]){
                    minval = nums[i];
                    minind = i;
                }
                if(maxval==-1 || maxval<=nums[i]){
                    maxval = nums[i];
                    maxind = i;
                }

                if(minval==mink && maxval==maxk){
                    // System.out.println(i-Math.abs(minind-maxind)-left);
                    res = res+ (Math.min(minind,maxind)-left);
                }
            }
        }
        return res;
    }
}