class Solution {
public:

    int dfs(int i,int n,vector<vector<int>>& adj,vector<int>& vis){
        vis[i] = 1;
        int cnt = 0;
        for(auto j : adj[i]){
            if(vis[j]==0){
                cnt += dfs(j,n,adj,vis);
            }
        }
        return 1+cnt;
    }
    long long countPairs(int n, vector<vector<int>>& edges) {
        // int n1 = edges.size();
        vector<vector<int>>  adj(n);
        for(auto i : edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }
        vector<int> vis(n,0);
        vector<long long> res;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                int cnt = dfs(i,n,adj,vis);
                res.push_back(cnt);
            }
        }
        // for(auto i : )
        
        vector<long long> bnt(res.size());
        int temp = 0;
        for(int i = res.size()-1;i>=0;i--){
            temp += res[i];
            bnt[i] = temp;
        }  
        long long ans = 0;
        for(int i=0;i<res.size()-1;i++){
            ans += res[i]*bnt[i+1];
        }
        return ans;
    }
};