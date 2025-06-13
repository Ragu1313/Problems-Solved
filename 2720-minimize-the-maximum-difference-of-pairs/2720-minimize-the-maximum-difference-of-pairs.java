class Solution {
    public int minimizeMax(int[] nums, int p) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        while(l<=r){
            int mid = l+(r-l)/2;
            int cnt = 0;
            for(int i=0;i<n-1;i++){
                if(nums[i+1]-nums[i]<=mid) {
                    cnt++;
                    i++;
                } 
            }
            if(cnt>=p){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}