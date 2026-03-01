class Solution {
    void pushZerosToEnd(int[] arr) {
        int left = 0;
        int right = 0;
        
        while(right<arr.length-1){
            while(left<arr.length && arr[left]!=0){
                left++;
            }
            right = left+1;
            while(right<arr.length && arr[right]==0){
                right++;
            }
            if(left<arr.length && right<arr.length){
                arr[left] = arr[right];
                arr[right] = 0;
                left++;
            }
        }
        
    }
}