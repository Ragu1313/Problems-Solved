class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m+n;
        int c=0;
        int s[] = new int[total];
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j])
               s[c++] = nums1[i++];
            else
                s[c++] = nums2[j++];
        }
        while(i<m || j<n && c<total){
            if(i<m)
              s[c++] = nums1[i++];
            if(j<n)
               s[c++] = nums2[j++];
        }
        for(i=0;i<total;i++){
           nums1[i] = s[i];
        }
    }
}