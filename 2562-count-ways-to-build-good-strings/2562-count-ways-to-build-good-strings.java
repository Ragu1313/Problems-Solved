class Solution {
    // int res
    int mod = 1_000_000_007;
    int arr[] ;
    public int f(int l,int h,int low,int high ,int len){
        if(len>high){
            return 0;
        }

        if(arr[len]!=-1){
            return arr[len];
        }

        int c = 0;
        if(len>=low && len<=high){
            c = 1;
        }
        
        int ll = f(l,h,low,high,len+l);
        int rr = f(l,h,low,high,len+h);
        // System.out.println(len+" "+ll+rr);
        return arr[len] = (c+ll+rr)%mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        arr = new int[high+1];
        Arrays.fill(arr,-1);
        // arr[0] = 0;
         return f(zero,one,low,high,0);
        // int res = 0;
        // for(int i=low;i<=high;i++){
        //     System.out.print(arr[i]+" ");
        //     res+=arr[i];
        // }
        // return res;
    }
}