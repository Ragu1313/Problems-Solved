class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int res[] = new int[nums.length];
        int temp[] = new int[31];
        Arrays.fill(res,1);
        for(int i=nums.length-1;i>=0;i--){
            for(int bit = 0;bit<=30;bit++){
                if(((nums[i]>>bit)&1)>0){
                    temp[bit] = i;
                }
                res[i] = Math.max(res[i],temp[bit] -i +1);
            }
        }
        return res;
    }
}