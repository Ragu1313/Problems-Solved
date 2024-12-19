class Solution {
    public int maxChunksToSorted(int[] arr) {
       int cnt = 0;
       int sum = 0;
       int res = 0;
       for(int i=0;i<arr.length;i++){
           cnt+=arr[i];
           sum+=i;
           if(cnt==sum){
             res++;
           }
       }
       return res;
    }
}