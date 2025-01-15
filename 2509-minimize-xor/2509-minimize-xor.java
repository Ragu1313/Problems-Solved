class Solution {
    public int minimizeXor(int nums1, int nums2) {
        // int n1 = Integer.bitCount(num1);
        int n2 = Integer.bitCount(nums2);
        // int cnt = n2;
        int res = 0;
        for(int i=31;i>=0;i--){
            if((nums1 & (1<<i) ) >0 && n2>0){
                n2--;
                res = res+(1<<i);
            }
        }
        for(int i=0;i<32;i++){
            if(n2>0 && (nums1 & (1<<i))==0){
                n2--;
                res = res+(1<<i);
            }
        }
        return res;
    }
}