class Solution {

    public int f(int left,int right,int arr[],int dp[][]){
        if(left>=right)  return 0;
        int res = 0;
        if(dp[left][right]!=-1)     return dp[left][right];
        for(int j=left+1;j<right;j++){
            res = Math.max(res, arr[left]*arr[right]*arr[j] + f(left,j,arr,dp) + f(j,right,arr,dp));
        }  
        return dp[left][right] = res;
    }
   
    public int maxCoins(int[] nums) {
       int n = nums.length;
       int arr[] = new int[n+2];
       arr[0] = 1;
       arr[n+1] = 1;
       for(int i=0;i<n;i++){
          arr[i+1] = nums[i];
       }
       int dp[][] = new int[n+2][n+2];
       for(int i[] : dp){
           Arrays.fill(i,-1);
       }
       return f(0,n+1,arr,dp);
    }
}