class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Long res = 0L;
        int cnt = 0;
        Map<Integer,Long> map = new HashMap<>();
        int n = nums.size();
        map.put(0,1L); 
        for(int i=0;i<n;i++){
            cnt += (nums.get(i)%modulo)==k?1:0;
            int rem = cnt%modulo;
            int need = (rem-k+modulo)%modulo;
            res += map.getOrDefault(need,0L);
            map.put(rem,map.getOrDefault(rem,0L)+1L);
        }
        return res;
    }
} 