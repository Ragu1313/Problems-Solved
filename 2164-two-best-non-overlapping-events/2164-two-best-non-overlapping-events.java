class Solution {
    public int f(int i,int k,int events[][],int dp[][]){
        if(i==events.length)  return 0;
        if(k==0)  return 0;
        if(dp[i][k]!=-1)   return dp[i][k];
        int next = bs(i,events[i][1],events);
        int pick = f(next,k-1,events,dp)+events[i][2];
        int notpick = f(i+1,k,events,dp);
        return dp[i][k] = Math.max(pick,notpick);
    }
    public int bs(int ind,int val,int events[][]){
        int low = ind;
        int high = events.length-1;
        int ans = high+1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(events[mid][0]>val){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[0] - b[0];
        });
        int dp[][] = new int[events.length][3];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(0,2,events,dp);
    }
}