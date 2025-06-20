class Solution {
    public int f(int i,int k,List<List<Integer>> piles,int dp[][]){

        if(k==0) return 0;
        if(i==-1) return 0;

        if(dp[i][k]!=-1)  return dp[i][k];

        int res = f(i-1,k,piles,dp);

        int sum = 0;
        List<Integer> list = piles.get(i);
        int n = Math.min(list.size(),k);
        for(int j=0;j<n;j++){
            sum+=list.get(j);
            res = Math.max(res,f(i-1,k-j-1,piles,dp)+sum) ;
        }
        return dp[i][k] = res;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n][k+2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return f(n-1,k,piles,dp);
    }
}