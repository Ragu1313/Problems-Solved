class Solution {
    int cnt = 0;
    public long[] merge(int left,int right,long arr[]){
        if(left==right)  return new long[]{arr[left]};
        int mid = left + (right-left)/2;
        long arr1[] = merge(left,mid,arr);
        long arr2[] = merge(mid+1,right,arr);
        int n = arr1.length+arr2.length;
        long temp[] = new long[n];
        int i = 0,j=0;
        while(i<arr1.length && j<arr2.length){
            while(i<arr1.length && arr1[i]<=2*arr2[j]) i++;
            cnt += arr1.length - i;
            j++;
        }
        i = 0;j=0;
        int cur = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                temp[cur++] = arr1[i++];
            }
            else{
                // double t = arr1[i]/2.0;
               
                temp[cur++] = arr2[j++];
            }
        }
        while(i<arr1.length){
            temp[cur++] = arr1[i++];
        }
        while(j<arr2.length){
            temp[cur++] = arr2[j++];
        }
        return temp;
    }
    public int reversePairs(int[] nums) {
        cnt = 0;
        long arr[] = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i]; 
        }
        merge(0,nums.length-1,arr);
        return cnt;
    }
}