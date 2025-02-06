class Solution {
public:
    int mod = 1e9+7;
    int f(int n,vector<vector<pair<int,int>>> adj){
        vector<long long > dis(n,LONG_MAX);
        vector<long  long> ways(n);
        dis[0] = 0;
        ways[0] = 1;
        priority_queue<pair<long long ,int> , vector<pair<long long,int>>,greater<pair<long long,int>> >p;
        p.push({0,0});
        while(!p.empty()){
            long long d = p.top().first;
            int v = p.top().second;p.pop();
            for(auto i : adj[v]){
                int node = i.first;
                int val = i.second;
                if(dis[node]>val+d){
                    dis[node] = val+d;
                    ways[node]  = ways[v];
                    p.push({val+d,node});
                }
                else if(dis[node]==val+d){
                    ways[node] = (ways[node]+ways[v])%mod;
                }
            }
        } 
        return ways[n-1];
    }
    int countPaths(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int,int>>> adj(n) ;
        for(auto i : roads){
            adj[i[0]].push_back({i[1],i[2]});
            adj[i[1]].push_back({i[0],i[2]});
        }
        return f(n,adj);
    }
};