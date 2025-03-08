class Solution {
    public boolean f(int i,int j,int n,int [] arr,int dp[][]){
        if(i==n-1){
            return true; 
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        int left = arr[i]+j-1;
        int right = arr[i]+j+1;
        boolean res = false;
        for(int ind = i+1;ind<n;ind++){
            if(arr[ind]<=right){
                if(arr[ind]==left){
                    res = res || f(ind,j-1,n,arr,dp);
                }
                else if(arr[ind]==arr[i]+j){
                    res = res || f(ind,j,n,arr,dp);
                }
                else if( arr[ind]==right){
                    res = res || f(ind,j+1,n,arr,dp);
                }
            }
            else {
                break ;
            }
        }
        dp[i][j] = res==true?1:0;
        return dp[i][j]==1;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1]!=1)    return false;
        int dp[][] = new int [n][n];
        for(int i[] : dp){
            // for(int j : i){
                Arrays.fill(i,-1);
            // }
        }
        
        return f(1,1,n,stones,dp);
    }
}