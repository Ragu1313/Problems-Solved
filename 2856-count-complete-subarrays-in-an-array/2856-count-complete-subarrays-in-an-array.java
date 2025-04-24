class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int lpoi = 0;
        int rpoi = 0;
        int cnt[] = new int[2001];
        int c = 0;
        for(int i : nums){
            if(cnt[i] == 0){
                cnt[i] = 1;
                c++;
            }
        }
        int temp [] = new int[2001];
        int cc = 0;
        int res = 0;
        while(rpoi<n){
            if(temp[nums[rpoi]]==0){
                cc++;
            }
            temp[nums[rpoi]]++;
            while(cc==c){
                if(temp[nums[lpoi]]==1){
                    cc--;
                }
                temp[nums[lpoi]]--;
                lpoi++;
                res += n-rpoi;
            }
            rpoi++;
        }
        return res;
    }
}