class Solution {
    int f(int start,int end,int cuts[],int dp[][]){
        
        if(dp[start][end]!=-1)   return dp[start][end];
        
        int res = (int)(1e7);

        for(int inx=0;inx<cuts.length;inx++){
            // System.out.println(cuts[start] + " "+ cuts[end]+" "+cuts[inx]);
            if(cuts[inx]>cuts[start] && cuts[inx]<cuts[end]){
                // System.out.println("HI");
                res = Math.min(res,f(start,inx,cuts,dp) + cuts[end] - cuts[start] + f(inx,end,cuts,dp));
            }
        }
        res= res==10000000?0:res;
        return dp[start][end] = res;
    }
    public int minCost(int n, int[] cuts) {
        int n1 = cuts.length;
        int arr[] = new int[n1+2];
        for(int i=1;i<=n1;i++){
            arr[i] = cuts[i-1];
        }
        n1+=2;
        arr[n1-1] = n;
        int dp[][] = new int[n1][n1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(0,n1-1,arr,dp);
    }
}