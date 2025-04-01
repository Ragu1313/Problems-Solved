class Solution {
    public long f(int i,int n,int[][] ques,long dp[]){
        if(i>=n)    return 0L;
        if(dp[i]!=-1)   return dp[i];
        long pick = ques[i][0] + f(i+ques[i][1]+1,n,ques,dp);
        long notpick = f(i+1,n,ques,dp);
        return dp[i] =  Math.max(pick,notpick);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return f(0,n,questions,dp);
    }
}