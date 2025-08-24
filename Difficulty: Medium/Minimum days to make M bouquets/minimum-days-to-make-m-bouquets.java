class Solution {
    public boolean f(int mid,int arr[],int k,int m){
        int cnt = 0;
        for(int i : arr){
            if(i<=mid){
                cnt++;
                if(cnt==k) {
                    m--;
                    cnt = 0;
                }
            }
            else{
                cnt = 0;
            }
        }
        return m<=0;
    }
    public int minDaysBloom(int[] arr, int k, int m) {
        int low = arr[0];
        int high = 0;
        for(int i : arr){
            low = Math.min(low,i);
            high = Math.max(high,i);
        }
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(f(mid,arr,k,m)){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}