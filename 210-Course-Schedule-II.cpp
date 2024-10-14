class Solution {
public:
    vector<int> findOrder(int num, vector<vector<int>>& pre) {
        vector<int> res;
        vector<vector<int>> adj(num); 
        vector<int> cnt(num,0);
        for(int i=0;i<pre.size();i++){
            int first = pre[i][1];
            int second = pre[i][0];
            adj[first].push_back(second);
            cnt[second]++;
        }
        // for(int i=0;i<)
        queue<int> q;
        for(int i=0;i<num;i++){
            if(cnt[i]==0) {
                q.push(i);
                res.push_back(i);
            }  
        }
        while(!q.empty()){
            int p = q.front();
            q.pop();
            for(int i:adj[p]){
                cnt[i]--;
                if(cnt[i]==0){
                    q.push(i);
                    res.push_back(i);
                }
            }
        }
        if(res.size()==num){
            return res;
        }
        else{
            return {};
        }
    }
};