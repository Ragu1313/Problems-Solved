class Solution {
public:
    int bfs(int i,int j,vector<vector<int>>&grid){
        queue<vector<int>> q;
        q.push({i,j});
        vector<int> v1 = {-1,0,1,0};
        vector<int> v2 = {0,-1,0,1};
        int sum = grid[i][j];
        grid[i][j] = 0;
        while(!q.empty()){
            vector<int> arr = q.front();
            int n = arr[0];
            int m = arr[1];
            // sum = sum+grid[n][m];
            q.pop();
            for(int i1=0;i1<4;i1++){
                int n1 = v1[i1]+n;
                int m1 = v2[i1]+m;
                if(n1>=0 && n1<grid.size() && m1>=0 && m1<grid[0].size() && grid[n1][m1]!=0){
                    sum = sum + grid[n1][m1];
                    grid[n1][m1] = 0;
                    q.push({n1,m1});
                }
            }
        }
        return sum;
    }
    int findMaxFish(vector<vector<int>>& grid) {
        int res = 0;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]>0)
                res = max(res,bfs(i,j,grid));
            }
        }
        return res;
    }
};