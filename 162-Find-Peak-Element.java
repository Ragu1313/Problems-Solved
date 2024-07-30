class Solution {
    public int binary(int i,int j,int []arr){
         while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                return mid;
            if(arr[mid]>arr[mid-1]){
                i = mid+1;
            }
            else 
                j = mid-1;
        }
        return -1;
    }
    
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==0 || n==1)
            return 0;
        if(arr[n-1]>arr[n-2])
            return n-1;
        if(arr[0]>arr[1])
            return 0;
        return binary(1,n-1,arr);
    }
}