class Solution {
    public int max1(int i,int flag,int n,int arr[],int dp[][]){
        if(i>n)
            return 0;
        int m = 0;
        if(flag==0)
            m = Math.max(max1(i+1,1,n,arr,dp)-arr[i],max1(i+1,0,n,arr,dp));
        else
            m = Math.max(max1(i+2,0,n,arr,dp)+arr[i],max1(i+1,1,n,arr,dp));
        return dp[i][flag] = m;
    }
    public int maxProfit(int[] arr) {
        // int dp [][] = new int [arr.length+2][2];
        int next[] = new int[2];
        int cur[] = new int[2];
        int nextnext[] = new int[2]; 
        for(int i=arr.length-1;i>=0;i--){
            int m=0;
            for(int flag=0;flag<2;flag++){
                if(flag==0)
                    m = Math.max(next[1]-arr[i],next[0]);
                else
                    m = Math.max(nextnext[0]+arr[i],next[1]);
                cur[flag] = m;
            }
            System.arraycopy(next, 0, nextnext, 0, 2);
            System.arraycopy(cur, 0, next, 0, 2);   
        }
        return cur[0];
    }
}