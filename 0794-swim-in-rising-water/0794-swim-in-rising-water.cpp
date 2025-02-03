using namespace std;
class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        priority_queue<vector<int>,vector<vector<int>> ,greater<vector<int>>> p;
        p.push({grid[0][0],0,0});
        vector<int> v1 = {-1,0,1,0};
        vector<int> v2 = {0,-1,0,1};
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis (n,vector<int>(m,0));
        vis[0][0] = 0;
        while(p.size()>0){
            vector<int> temp = p.top();p.pop();
            int val = temp[0];
            int ii = temp[1];
            int jj = temp[2]; 
            if(ii==n-1 && jj==m-1)  return val;
            for(int i=0;i<4;i++){
                int newi = ii + v1[i] ;
                int newj = jj + v2[i] ; 
                if(newi>=0 && newi<n && newj>=0 && newj<m && vis[newi][newj]==0){
                    vis[newi][newj] = 1;
                    if(grid[newi][newj]>val){
                        p.push({grid[newi][newj],newi,newj});
                    }
                    else{
                        p.push({val,newi,newj});
                    }
                }
            }
        }
        return -1;
    }
};