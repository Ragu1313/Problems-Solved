class Solution {
    public int search(int[] arr, int k) {
        if(arr.length==1)
            return arr[0]==k?0:-1;
       int i = 0;
       int j = arr.length-1;
       while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==k)
                return mid;
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
       return -1;
    }
}