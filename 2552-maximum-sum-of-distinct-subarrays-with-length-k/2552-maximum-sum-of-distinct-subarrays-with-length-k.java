class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k) res = sum;
        for(int i=k;i<n;i++){
            sum -= nums[i-k];
            map.put(nums[i-k],map.get(nums[i-k])-1);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum += nums[i];
            if(map.get(nums[i-k])==0){
                map.remove(nums[i-k]);
            }
            if(map.size()==k)   res = Math.max(res,sum);
        }
        return res;
    }
}