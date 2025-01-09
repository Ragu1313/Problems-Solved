class Solution {
    public int candy(int[] arr) {
        int res = 1;
        int n = arr.length;
        int l = 1;
        // int pcost = 1;
        while(l<n){
            // pcost = 1;
            while(l<n &&  arr[l]==arr[l-1]){
                l++;
                res++;
                // continue;
            }
            int pcost = 1;
            while(l < n && arr[l]>arr[l-1]){
                pcost++;
                res+=pcost;
                l++;
            }
            int small = 1;
            while(l < n && arr[l]<arr[l-1]){
                res+=small;
                small++;
                l++;
            }
            if(small>pcost)
            res = res+small-pcost;   
        }
        return res;
    }
}