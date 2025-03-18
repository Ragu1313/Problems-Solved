class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sum = 0;
        int xor = 0;
        int l = 0;
        int res = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            xor ^= nums[i];
            
            
            if(sum==xor)   {
                res = Math.max(res,i-l+1);
            }
            else{
                while(sum!=xor){
                    sum -= nums[l];
                    xor ^= nums[l];
                    l++;
                }
            }
        }
        return res;
    }
}