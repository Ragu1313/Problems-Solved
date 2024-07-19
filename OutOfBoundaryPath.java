/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6

Example 2:

Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12

 

Constraints:

    1 <= m, n <= 50
    0 <= maxMove <= 50
    0 <= startRow < m
    0 <= startColumn < n


*/
class Solution {
     private static final int mod = 1_000_000_007;
      public int find(int startrow,int startColumn,int maxMove,int m,int n,int dp[][][]){
        if(maxMove<0 )
            return 0;
        if(startrow<0 || startrow>=m || startColumn<0 || startColumn>=n){
            return 1;
        }
        if(dp[startrow][startColumn][maxMove]!=-1)
            return dp[startrow][startColumn][maxMove];
        int left = find(startrow,startColumn-1,maxMove-1,m,n,dp);
        int top = find(startrow+1,startColumn,maxMove-1,m,n,dp);
        int bottom = find(startrow-1,startColumn,maxMove-1,m,n,dp);
        int right = find(startrow,startColumn+1,maxMove-1,m,n,dp);
        dp[startrow][startColumn][maxMove] = ((left+right)% mod + (top + bottom)%mod)%mod;
        return dp[startrow][startColumn][maxMove];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] dp = new int[m][n][maxMove+1];
        for(int [][] i: dp){
            for(int [] j: i){
                Arrays.fill(j,-1);
            }
        }  
        return find(startRow,startColumn,maxMove,m,n ,dp);
    }
}
