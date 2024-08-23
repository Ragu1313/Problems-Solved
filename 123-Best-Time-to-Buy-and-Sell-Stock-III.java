class Solution {
    public int max1(int i,int flag,int count,int n,int arr[],int dp[][][]){
        if(i>n)
            return 0;
        if(count>=2)
            return 0;
        if(dp[i][flag][count]!=-1)
            return dp[i][flag][count];
        int m = 0;
        if(flag==0)
            m = Math.max(max1(i+1,1,count,n,arr,dp)-arr[i],max1(i+1,0,count,n,arr,dp));
        else
            m = Math.max(max1(i+1,0,count+1,n,arr,dp)+arr[i],max1(i+1,1,count,n,arr,dp));
        return dp[i][flag][count] = m;
    }
    public int maxProfit(int[] arr) {
        int dp [][][] = new int [arr.length+1][2][3];
        int m;
        for(int i=arr.length-1;i>=0;i--){
            for(int flag=0;flag<2;flag++){
                for(int count=0;count<2;count++){
                    if(flag==0)
                        m = Math.max(dp[i+1][1][count]-arr[i],dp[i+1][0][count]);
                    else
                        m = Math.max(dp[i+1][0][count+1]+arr[i],dp[i+1][1][count]);
                    dp[i][flag][count] = m;
                }
            }
        }
        return dp[0][0][0];
    }
}