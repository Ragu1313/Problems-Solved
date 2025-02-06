class Solution {
public:
    vector<int> bfs(int i,vector<vector<int>>& adj ,vector<int>& vis ,int cnt){
        vector<int> arr;
        vis[i] = cnt;
        queue<int> q ;
        q.push(i);
        arr.push_back(i);
        while(!q.empty()){
            int node = q.front();q.pop();
            for(auto k : adj[node]){
                if(vis[k]==0){
                    q.push(k);
                    vis[k] = cnt;
                    arr.push_back(k);
                }
            }
        }
        return arr;
    }
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        // map<int,vector<int>> m;
        vector<vector<int>> adj (n);
        vector<int> in(n,0);
        for(auto i : edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
            in[i[0]]++;
            in[i[1]]++;
        }
        vector<int> vis(n,0);
        int cnt = 1;
        int res = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                vector<int> node = bfs(i,adj,vis,cnt);
                cnt++;
                int c = node.size()-1;
                int flag = 0;
                for(auto k : node){
                    if(in[k]!=c){
                        flag = 1;
                        break;
                    }
                }
                if(flag==0) res++; 
            }
        }
        return res;
    }
};