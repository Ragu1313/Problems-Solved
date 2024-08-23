class Solution {
    public int max1(int i,int flag,int count,int n,int arr[],int dp[][][]){
        if(i>n)
            return 0;
        if(count>=2)
            return 0;
        if(dp[i][flag][count]!=-1)
            return dp[i][flag][count];
        int m = 0;
        if(flag==0){
            m = Math.max(max1(i+1,1,count,n,arr,dp)-arr[i],max1(i+1,0,count,n,arr,dp));
        }
        else
            m = Math.max(max1(i+1,0,count+1,n,arr,dp)+arr[i],max1(i+1,1,count,n,arr,dp));
        return dp[i][flag][count] = m;
    }
    public int maxProfit(int[] arr) {
        int dp [][][] = new int [arr.length][2][2];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return max1(0,0,0,arr.length-1,arr,dp);
    }
}