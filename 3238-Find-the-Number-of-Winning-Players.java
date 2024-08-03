class Solution {
    public int winningPlayerCount(int n, int[][] mat) {
        int dp[][] = new int [n][11];
        for(int i=0;i<mat.length;i++){
            dp[mat[i][0]][mat[i][1]]++;
        }
        int c=0;
        for(int i=0;i<dp.length;i++){
            for(int j: dp[i]){
                if(i<j){
                    c++;
                    break;
                }        
            }
        }
        return c;
    }
}