class Solution {
    public int f(int i,int k,int events[][],int dp[][]){
        if(i==events.length)  return 0;
        if(k==0) return 0;
        if(dp[i][k]!=-1)  return dp[i][k];
        int next = bs(events,events[i][1],i);
        int pick = f(next,k-1,events,dp) + events[i][2];
        // System.out.println(i+" "+next);
        int notpick = f(i+1,k,events,dp);
        return dp[i][k] = Math.max(pick,notpick);
    }
    public int bs(int events[][],int i,int ind){
        // if(i+1==events.length) return i+1;
        int low = ind;
        int high = events.length-1;
        int ans = events.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            // if(events[mid][1]>i && events[mid-1][1]==i) return mid;
            if(events[mid][0]>i){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->{
            if(a[0]!=b[0])  return a[0]-b[0];
            return a[1] - b[1];
        });
        int dp[][] = new int[events.length][k+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(0,k,events,dp);
    }
}