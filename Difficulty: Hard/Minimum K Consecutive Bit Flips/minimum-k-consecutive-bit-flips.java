class Solution {
    public int kBitFlips(int[] arr, int k) {
         int res = 0;
         int n = arr.length;
         int cnt[] = new int[n];
         int prev = 0;
         
         for(int i=0;i<=n-k;i++){
             prev+=cnt[i];
             if((arr[i]+prev)%2==0 ){
                 res++;
                 cnt[i]++;
                 prev++;
                 if(i+k<n){
                     cnt[i+k]--;
                 }
             }
         }
         prev = 0;
         for(int i=0;i<n;i++){
             prev += cnt[i];
            //  System.out.println(arr[i]+" "+prev);
             if((arr[i]+prev)%2==0)  return -1;
         }
         return res;
    }
}
