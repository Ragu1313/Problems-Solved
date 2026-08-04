class Solution {
    public static int countPairs(int arr[], int k) {
        if(arr.length==1)   return 0;
        Arrays.sort(arr);
        int left = arr.length-2;
        int right = left+1;
        int res = 0;
        while(left>=0 && right>=left){
            if(arr[right]-arr[left]<k){
                res+=right-left;
                left--;
            }else{
                right--;
            }
        }
        return res;
    }
}
