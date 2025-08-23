class Solution {
    public boolean f(int arr[],int mid,int k){
        int sum = 0;
        int cnt = 0;
        for(int i : arr){
            
            if(sum+i>mid){
                cnt++;
                sum = i;
            }else{
                sum+=i;
            }
        }
        if(sum>0)  cnt++; 
        return cnt<=k;
    }
    public int findPages(int[] arr, int k) {
        if(k>arr.length)  return -1;
        int high = 0;
        int low = 0;
        for(int i : arr){
            low = Math.max(low,i);
            high += i;
            
        }
        
        int res = -1;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            // System.out.println(mid);
            // System.out.println(f(arr,mid,k));
            if(f(arr,mid,k)){
                res = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return res;
    }
}