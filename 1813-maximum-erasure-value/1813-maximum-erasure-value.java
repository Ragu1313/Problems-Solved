class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int vis[] = new int[10001];
        int right = 0;
        int sum = 0;
        int res = 0;
        int left = 0;
        while(right<nums.length){
            while(vis[nums[right]]==1){
                sum -= nums[left];
                vis[nums[left]]--;
                left++;
            }
            
            vis[nums[right]]++;
            sum+=nums[right];
            right++;
            res = Math.max(sum,res);
        }
        return res;
    }
}