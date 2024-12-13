class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(nums[0]<=nums[1]){
            res+=nums[0];
            nums[0] = Integer.MAX_VALUE;
            nums[1] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n-1;i++){
            if(nums[i]!=Integer.MAX_VALUE){
                if(nums[i-1]>=nums[i] && nums[i]<=nums[i+1]){
                    res+=nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    nums[i-1] =  Integer.MAX_VALUE;
                    nums[i+1] =  Integer.MAX_VALUE;
                }
            }
            
        }
        if(nums[n-1] !=Integer.MAX_VALUE && nums[n-2]>=nums[n-1]){
            res+=nums[n-1];
            nums[n-1] = Integer.MAX_VALUE;
            nums[n-2] = Integer.MAX_VALUE;
        }
        if(nums[n-1] !=Integer.MAX_VALUE && nums[n-2]<nums[n-1]){
            res+=nums[n-2];
            nums[n-1] = Integer.MAX_VALUE;
            nums[n-2] = Integer.MAX_VALUE;
        }
        for(int i=n-1;i>0;i--){
            if(nums[i]!=Integer.MAX_VALUE){
                if(nums[i-1]>=nums[i] && nums[i]<=nums[i+1]){
                    res+=nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    nums[i-1] =  Integer.MAX_VALUE;
                    nums[i+1] =  Integer.MAX_VALUE;
                }
            }
        }
        if(nums[0]!=Integer.MAX_VALUE && nums[1]>=nums[0]){
            res+=nums[0];
            nums[0] = Integer.MAX_VALUE;
            nums[1] = Integer.MAX_VALUE;
        }
        return res;
    }
}