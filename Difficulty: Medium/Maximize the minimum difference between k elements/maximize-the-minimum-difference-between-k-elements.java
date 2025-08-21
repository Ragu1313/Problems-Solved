class Solution {
    public boolean valid(int mid,int arr[],int k){
        int prev = arr[0];
        k--;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev>=mid){
                prev = arr[i];
                k--;
            }
        }
        return k<=0;
    }
    public int maxMinDiff(int[] arr, int k) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int res = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println(mid);
            if(valid(mid,arr,k)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }
}
