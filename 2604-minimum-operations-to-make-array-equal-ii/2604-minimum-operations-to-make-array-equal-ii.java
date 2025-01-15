class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long dif[] = new long[n];
        for(int i=0;i<n;i++){
            dif[i] = nums1[i] - nums2[i];
        }
        long res = 0;
        long cnt1 = 0;
        long cnt2= 0;
        for(long i : dif){
            System.out.println(i);
            if(k==0){
                if(i!=0){
                    return -1;
                }
                continue;
            }
            if(i<0 && i%k==0){
                cnt2 = cnt2 + -i/k;
            }
            else if(i>0 && i%k==0){
                cnt1 = cnt1+i/k;
            }
        }
        if(cnt1==cnt2)  return cnt1;
        return -1;
    }
}