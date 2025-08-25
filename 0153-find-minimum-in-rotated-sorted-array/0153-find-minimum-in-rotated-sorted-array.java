class Solution {
    // public int binarySearch(int num[]){
    //     int 
    // }
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int res = -1;
        while(l<=h){
           int mid = (l+h)/2;
           if(res==-1 ||  nums[res]>nums[mid]){
              res = mid;
           }
           if(nums[mid]<nums[h]){
                // System.out.println(mid+" "+nums[mid]+" "+nums[h]);
                h = mid-1;
           }
           else{
            l = mid+1;
           }
        }
        return nums[res];
    }
}