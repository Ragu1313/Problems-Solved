class Solution {
    public boolean check(int arr[],int k){
        int n = arr.length;
        for(int i=0;i<=n-k-k;i++){
            if( (arr[i]>=k-1 && arr[i+k]>=k-1) ){
                return true;
            }
            if(arr[i]+1>=k*2){
                return true;
            }
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int arr[] = new int[n];
        // int cnt[] = new int[n+1];
        for(int i=n-2;i>=0;i--){
            if(nums.get(i)<nums.get(i+1)){
                arr[i] = arr[i+1] + 1;
                
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        int res = 1;
        int left = 1;
        int right = n;
        while(left<=right){
            int mid = left + (right - left) /2;
            if(check(arr,mid)){
                res = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return res;
    }
}