class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        int cnt[] = new int[100001];
        int n = nums.length;
        int ele = 0;
        // int sum = 0;
        for(int i=0;i<k;i++){
            cnt[nums[i]]++;
            sum+=nums[i];
            if(cnt[nums[i]]==1){
                ele++;
            }
        }
        long res = 0;
        if(ele == k){
            res = sum;
        }
        for(int i=k;i<n;i++){
            sum-=nums[i-k];
            cnt[nums[i-k]]--;
            sum+=nums[i];
            if(cnt[nums[i-k]]==0)   ele--;
            cnt[nums[i]]++;
            if(cnt[nums[i]]==1) ele++;
            if(ele==k)  res = Math.max(res,sum);
        }
        return res;
    }
}