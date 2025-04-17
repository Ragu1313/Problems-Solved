class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int lpoi = 0;
        long res = 0;
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int rpoi=0 ; rpoi<n;rpoi++){
            map.put(nums[rpoi],map.getOrDefault(nums[rpoi],0)+1);
            cnt += map.get(nums[rpoi])-1;
            while(lpoi<rpoi && cnt>=k){
                res += n-rpoi;
                map.put(nums[lpoi],map.get(nums[lpoi])-1);
                // int temp = map.get(nums[lpoi])*(map.get(nums[lpoi])+1)/2;
                cnt -= map.get(nums[lpoi]);
                lpoi++;
            }
        }
        return res;
    }
}