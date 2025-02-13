class Solution {
public:
    int timer = 1;
    void f(int v,int parent,vector<int>& vis,vector<int>& tim,vector<int>& low,vector<vector<int>>& res,vector<vector<int>>& adj){
        vis[v] = 1;
        tim[v] = low[v] =  timer;timer++;
        for(auto i : adj[v]){
            if(i==parent)   continue;
            if(vis[i]==0){
                vis[i] = 1 ;
                f(i,v,vis,tim,low,res,adj);
                
                if(low[i]>tim[v]){
                    res.push_back({i,v});
                } 
                low[v] = min(low[i],low[v]);
            }
            else {
                low[v] = min(low[i],low[v]);
            }
        }
    }
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<vector<int>> adj(n);
        for(auto i : connections){
            adj[i[1]].push_back(i[0]);
            adj[i[0]].push_back(i[1]);
        }
        vector<int> vis(n);
        vector<int> tim(n);
        vector<int> low(n);
        vector<vector<int>> res;
        f(0,-1,vis,tim,low,res,adj);
        return res;
    }
};