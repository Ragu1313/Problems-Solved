class Solution {
    // public int max1(int i,int flag,int count,int k,int n,int arr[],int dp[][][]){
    //     if(i>n)
    //         return 0;
    //     if(count>=k)
    //         return 0;
    //     if(dp[i][flag][count]!=-1)
    //         return dp[i][flag][count];
    //     int m = 0;
    //     if(flag==0){
    //         m = Math.max(max1(i+1,1,count,k,n,arr,dp)-arr[i],max1(i+1,0,count,k,n,arr,dp));
    //     }
    //     else
    //         m = Math.max(max1(i+1,0,count+1,k,n,arr,dp)+arr[i],max1(i+1,1,count,k,n,arr,dp));
    //     return dp[i][flag][count] = m;
    // }
    public int maxProfit(int k, int[] arr) {
        int next [][] = new int [2][k+1];
        int cur [][] = new int[2][k+1];
        int m;
        for(int i=arr.length-1;i>=0;i--){
            for(int flag=0;flag<2;flag++){
                for(int count=0;count<k;count++){
                    if(flag==0)
                        m = Math.max(next[1][count]-arr[i],next[0][count]);
                    else
                        m = Math.max(next[0][count+1]+arr[i],next[1][count]);
                    cur[flag][count] = m;
                }
                cur = next;
            }
        }
        return cur[0][0];
    }
}