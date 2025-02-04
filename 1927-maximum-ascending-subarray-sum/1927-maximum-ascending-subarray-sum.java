class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int prev = 0;
        int res = 0;
        for(int i : nums){
            if(prev<i){
                sum+=i;
            }
            else{
                sum=i;
            }
            res = Math.max(res,sum);
            prev = i;
        }
        return res;
    }
}