class Solution {
    public boolean f(int k,int nums[],int mid){
        int cnt = 0;
        int i = 0;int n = nums.length;
        while(i<n){
            if(nums[i]<=mid){
                i+= 2;
                cnt++;
            }
            else{
                i++;
            }
        }
        return cnt>=k;
    }
    public int minCapability(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int l = min;
        int r = max;
        int res = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(f(k,nums,mid)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}