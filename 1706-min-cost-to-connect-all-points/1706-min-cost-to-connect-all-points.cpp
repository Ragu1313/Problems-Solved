class Disjoint{
public:
    vector<int> rank;
    vector<int> par;
    Disjoint(int n){
        // dis.resize(n,INT_MAX);
        rank.resize(n,1);
        par.resize(n);
        for(int i=0;i<n;i++){
            par[i] = i;
        }
        // for(int )
    }
    int parent(int i){
        if(par[i]==i)   return i;
        int temp = parent(par[i]);
        par[i]  =temp;
        return temp;
    }
    void join(int i,int u){
        int p1 = par[i];
        int p2 = par[u];
        if(p1!=p2){
            if(rank[p1]>rank[p2]){
            // rank[p1]++;
                par[p2] = p1;
            }
            else if(rank[p2]>rank[p1]){
                par[p1] = p2;
            }
            else{
                rank[p2]++;
                par[p1] = p2;
            }
        }
        
    }
};

class Solution {
public:
    int f(int n,priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>>&p){
        Disjoint dis(n);
        // vector<int> di(n,INT_MAX);
        int res = 0;
        while(!p.empty()){
            vector<int> temp = p.top();p.pop();
           
            int src = temp[1];
            int des = temp[2];
            int val = temp[0];
            // cout<<val<<" "<<src<<" "<<des<<" "<<endl;
            if(dis.parent(src)!=dis.parent(des)){
                res+=val;
                dis.join(src,des);
            }
        }
        return res;
    }
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> q;
        for(int i=0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];
            for(int j=i+1;j<n;j++){
                int xx = points[j][0];
                int yy = points[j][1];
                int dis = abs(xx-x)+abs(yy-y);
                q.push({dis,i,j});
            }
        }
        return f(n,q);
    }
};