class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = Long.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    long temp = nums[i]-nums[j];
                    temp = temp*nums[k];
                    res = Math.max(temp,res);
                }
            }
        }
        // System.out.println(res);
        if(res<0)   return 0L;
        return res;
    }
}