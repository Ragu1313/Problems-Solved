class Solution {
    public int count(int arr[],int n,int limit){
        int res = 0;
        int left = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+= arr[i];
            while(sum>limit){
                sum -= arr[left++];
            }
            res += (i-left+1);
        }
        return res;
    }
    public int countSubarray(int[] arr, int l, int r) {
        return count(arr,arr.length,r) - count(arr,arr.length,l-1);
    }
}