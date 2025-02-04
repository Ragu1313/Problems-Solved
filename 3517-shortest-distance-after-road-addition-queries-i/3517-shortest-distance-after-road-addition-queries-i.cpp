// #include<bit/stdc++.h>
using namespace std;
class Solution {
public:
    int f(vector<vector<int>>& adj,vector<int> &wei,int n){
        priority_queue<vector<int> , vector<vector<int>> , greater<vector<int>> > p;
        p.push({0,0});
        wei[0] = 0;
        while(!p.empty()){
            vector<int> temp = p.top();
            p.pop();
            if(temp[1]==n-1)
                return temp[0];
            int val = temp[0]+1;
            for(auto i : adj[temp[1]]){
                if(wei[i]>=val){
                    wei[i] = val;
                    p.push({val,i});
                }  
            }
        }
        return wei[n-1];
    };
    vector<int> shortestDistanceAfterQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> adj (n) ;
        vector<int> weight (n,INT_MAX);

        for(int i=0;i<n-1;i++){
            adj[i].push_back(i+1);
        }
        vector<int> res;
        for(auto i : queries){
            int src = i[0];
            int des = i[1];
            adj[src].push_back(des);
            res.push_back(f(adj,weight,n));
        }
        return res;
    }
};