class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long prev[] = new long[n];
        long suf[] = new long[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prev[i] = sum;
        }
        sum = 0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            suf[i] = sum;
        }
        int res = 0;
        for(int i=0;i<n-1;i++){
            // System.out.println(prev[i] + " "+suf[i+1]);
            if(prev[i]>=suf[i+1]){
                res++;
            }
        }
        return res;
    }
}