class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int prev = -1;
        int cnt = 0;
        int res = 0;
        for(int i : nums){
            if(prev<i){
                cnt++;
            }
            else{
                cnt = 1;
            }
            prev = i;
            res = Math.max(res,cnt);
        }
        prev = 100;
        cnt = 0;
        for(int i : nums){
            if(prev>i){
                cnt++;
            }
            else{
                cnt = 1;
            }
            prev = i;
            res = Math.max(res,cnt);
        }
        return res;
    }
}