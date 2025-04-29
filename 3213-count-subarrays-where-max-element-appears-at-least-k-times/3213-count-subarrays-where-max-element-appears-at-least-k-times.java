class Solution {
    public long countSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int great = 0,cnt = 0;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(i>=great){
                great = i;
                cnt = map.get(i);
            }
        }
        int right = 0;
        int left = 0;
        int n = nums.length;
        cnt = 0;
        long res = 0;
        while(right<n){
            if(nums[right]==great){
                cnt++;
            }
            while(cnt>=k){
                if(nums[left]==great)   cnt--;
                res+= (n-right);
                left++;
            }
            right++;
        }
        return res;
    }
}