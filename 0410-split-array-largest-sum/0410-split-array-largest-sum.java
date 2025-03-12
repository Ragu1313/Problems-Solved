class Solution {
    public boolean f(int nums[],int mid,int k){
        int tot = 0;
        int cnt = 1;
        for(int i : nums){
            if(i>mid)   return false;
            else if (tot+i<=mid)    tot += i;
            else{
                tot = i;cnt++;
            }
        }
        if(cnt>k)   return false;
        return true;
    }
    public int f1(int l,int r,int nums[],int k){
        int res = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(f(nums,mid,k)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
    public int splitArray(int[] nums, int k) {
        int tot = 0;
        for(int i : nums){
            tot += i;
        }
        return f1(0,tot,nums,k);
    }
}