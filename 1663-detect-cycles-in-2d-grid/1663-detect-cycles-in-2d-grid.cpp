#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool f(int i,int j,int ii,int jj,int n,int m,vector<vector<char>> & grid,vector<vector<bool>>& vis){
        if( ii!=-1 && jj!=-1 ){
            if(i<0 || i>=n || j>=m || j<0 || grid[i][j]!=grid[ii][jj]){
                return false;
            }
        }
        if(vis[i][j])   return true;
        
        vis[i][j] = true;
        bool foundCycle = false;
        if (i + 1 != ii) foundCycle |= f(i + 1, j, i, j, n, m, grid, vis);
        if (i - 1 != ii) foundCycle |= f(i - 1, j, i, j, n, m, grid, vis);
        if (j + 1 != jj) foundCycle |= f(i, j + 1, i, j, n, m, grid, vis);
        if (j - 1 != jj) foundCycle |= f(i, j - 1, i, j, n, m, grid, vis);

        return foundCycle;
    }
    bool containsCycle(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> vis(n,vector<bool>(m,false));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(f(i,j,-1,-1,n,m,grid,vis)) {
                        // cout<<i<<" "<<j;
                        return true;
                    }
                }
            }
        }
        return false;
    }
};