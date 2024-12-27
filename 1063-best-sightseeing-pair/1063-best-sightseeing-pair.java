class Solution {
    // public int f(int i,int flag ,int arr[],int dp[][]){
    //     if(i<0 || flag==2){
    //         return 0;
    //     }
    //     if(dp[i][flag]!=-1){
    //         return dp[i][flag];
    //     }
    //     int pick = Integer.MIN_VALUE;
    //     int notpick ;
    //     if(flag==0)
    //         pick = arr[i] -i+ f(i-1,flag+1,arr,dp);
    //     else{
    //         pick = arr[i]+ i+f(i-1,flag+1,arr,dp);
    //     }
    //     notpick = f(i-1,flag,arr,dp);
    //     return dp[i][flag] =  Math.max(pick,notpick);
    // }
    public int maxScoreSightseeingPair(int[] values) {
        int maxi = Integer.MIN_VALUE;
        int n = values.length;
        int left = values[0];
        for(int i=1;i<n;i++){
            maxi = Math.max(maxi,left+values[i]-i);
            left = Math.max(left,values[i]+i);
        }
        return maxi;
    }
}