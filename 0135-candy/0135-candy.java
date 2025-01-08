class Solution {
    public int candy(int[] arr) {
        int res = 0;
        int n = arr.length;
        // int arr1[] = new int[n];
        int arr2[] = new int[n];
        // arr1[0] = 1;
        arr2[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                arr2[i] = arr2[i+1]+1;
            }
            else{
                arr2[i] = 1;
            }
        }
        int prev = 1;
        // int ele = arr[0];
        res += Math.max(prev,arr2[0]);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                prev = prev+1;
            }
            else{
                prev = 1;
            }
            res+=Math.max(prev,arr2[i]);
            
        }
        return res;
    }
}