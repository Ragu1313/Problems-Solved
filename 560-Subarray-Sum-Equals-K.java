class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int res = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            cnt = cnt+nums[i];
            int temp = cnt-k;
            // if(nums[i]==k && temp==k)  res++;
            if(map.containsKey(temp))  res+=map.get(temp);
            if(map.containsKey(cnt))   map.put(cnt,map.get(cnt)+1);
            else map.put(cnt,1);
        }
        return res;
    }
}