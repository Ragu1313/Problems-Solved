class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long cnt = 0;
        for(int i : nums){
            if(i==0){
                cnt++;
            }
            else{
                res += ((cnt*(cnt+1))/2);
                cnt = 0;
            }
        }
        res += ((cnt*(cnt+1))/2);
        return res;
    }
}