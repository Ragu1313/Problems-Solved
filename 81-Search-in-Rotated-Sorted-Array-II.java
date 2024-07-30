class Solution {
    // public boolean search(int[] nums, int target) {
     public boolean search(int[] arr, int k) {
        if(arr.length==1)
            return arr[0]==k;
       int i = 0;
       int j = arr.length-1;
       while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==k)
                return true;
            if(arr[mid]==arr[i] && arr[mid]==arr[j]){
                i = i+1;
                j = j-1;continue;
            }
            if(arr[i]<=arr[mid]){
                if(arr[i]<=k && arr[mid]>=k)
                    j = mid-1;
                else
                    i = mid+1;
            }
            else{
                if(arr[mid]<=k && arr[j]>=k)
                    i = mid+1;
                else
                    j=mid-1;
            }
       }
       return false;
     }
}