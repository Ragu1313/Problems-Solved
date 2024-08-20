class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length ;
        int n = nums2.length;
        int a[] = new int[m+n];
        int l = m+n;
        int c=0;
        float result=0;int i,j;
        for(i=0;i<m;i++){
            a[i]=nums1[i];
        }
        for(j=m;j<m+n;j++){
            a[j] = nums2[c++];
        }
        Arrays.sort(a);
        if(l%2==0){
          result = (float)(a[l/2]+a[(l-1)/2])/2;
        }
        else{
            result = a[(l)/2];
        }
          
        return result; 
    }
}