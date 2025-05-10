class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long cnt1 = 0;
        long cnt2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i : nums1){
            if(i==0)    cnt1++;
            sum1+=i; 
        }
        for(int i : nums2){
            if(i==0)    cnt2++;
            sum2+=i;
        }
        sum1+=cnt1;
        sum2+=cnt2;
        if(cnt1==0 && sum1<sum2)    return -1;
        else if(cnt2==0 && sum1>sum2)  return -1;
        return Math.max(sum1,sum2);
    }
}