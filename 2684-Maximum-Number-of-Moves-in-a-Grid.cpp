class Solution {
public:
    int maxi(int i,int j,vector<vector<int>>& grid,vector<vector<int>> &dp){
        int n = grid.size();
        int m = grid[0].size();
        if(i==n || j==m || i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left = 0;
        if(i-1>=0 && j+1<m && grid[i-1][j+1]>grid[i][j]){
            left = 1 + maxi(i-1,j+1,grid,dp);
        }
        int right = 0;
        if(j+1<m && grid[i][j+1]>grid[i][j]){
            right = 1 + maxi(i,j+1,grid,dp);
        }
        int dia = 0;
        if(i+1<n && j+1<m && grid[i+1][j+1]>grid[i][j]){
            dia = 1 + maxi(i+1,j+1,grid,dp);
        }
        return dp[i][j] = max(left,max(right,dia));
        
    }
    int maxMoves(vector<vector<int>>& grid) {
        int res = 0;
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        for(int i=0;i<n;i++)
            res = max(res,maxi(i,0,grid,dp));
        return res;
    }
};