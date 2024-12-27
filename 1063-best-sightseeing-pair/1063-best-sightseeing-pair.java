class Solution {
    public int f(int i,int flag ,int arr[],int dp[][]){
        if(i<0 || flag==2){
            return 0;
        }
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        int pick = Integer.MIN_VALUE;
        int notpick ;
        if(flag==0)
            pick = arr[i] -i+ f(i-1,flag+1,arr,dp);
        else{
            pick = arr[i]+ i+f(i-1,flag+1,arr,dp);
        }
        notpick = f(i-1,flag,arr,dp);

        return dp[i][flag] =  Math.max(pick,notpick);
    }
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int [][] dp = new int[n][2];
        // for(int i[][]:dp){
            for(int j[]:dp){
                Arrays.fill(j,-1);
            }
        // }
        return f(n-1,0,values,dp);
    }
}