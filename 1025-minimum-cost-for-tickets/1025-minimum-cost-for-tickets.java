class Solution {

    public int f(int i,int arr[],int costs[],int dp[]){
        if(i>365){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(arr[i]==0){
            int f1 = f(i+1,arr,costs,dp);
            return dp[i] = f1;
        }
        int f1 = costs[0] + f(i+1,arr,costs,dp);
        int f2 = costs[1] + f(i+7,arr,costs,dp);
        int f3 = costs[2] + f(i+30,arr,costs,dp);
        return dp[i] = Math.min(f1,Math.min(f2,f3));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int arr[] = new int[366];
        for(int i:days){
            arr[i] = 1;
        }
        int dp[] = new int[366];
        Arrays.fill(dp,-1);
        return f(1,arr,costs,dp);
    }
}