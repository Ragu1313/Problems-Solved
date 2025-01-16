class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if( (n1&1)==0 && (n2&1)==0){
            return 0;
        }
        int res = 0;
        if((n1&1)==1 && (n2&1)==1){
            for(int i : nums1){
                res = res^i;
            }
            for(int i : nums2){
                res = res^i;
            }
            return res;
        }
        if((n1&1)==1){
            for(int i : nums2){
                res = res^i;
            }
            return res;
        }
        if((n2&1)==1){
            for(int i : nums1){
                res = res^i;
            }
            return res;
        }
        return 0;
    }
}