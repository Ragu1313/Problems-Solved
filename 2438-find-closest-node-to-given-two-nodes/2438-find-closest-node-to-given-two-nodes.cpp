using namespace std;
class Solution {
public:
    vector<int> f(int src,vector<int> &edges){
        queue<int> q;
        int n = edges.size();
        vector<int> weight (n,INT_MAX);
        q.push(src);
        weight[src] = 0;
        int cnt = 0;
        while(!q.empty()){
            int temp = q.front();
            q.pop();
            cnt++;
            if(edges[temp]!=-1 && weight[edges[temp]]==INT_MAX){
                q.push(edges[temp]);
                weight[edges[temp]] = cnt;
            }
        }
        return weight;
    }
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        if(node1==node2)    return node1;
        vector<int> arr1 = f(node1,edges);
        vector<int> arr2 = f(node2,edges);
        int n = arr1.size();
        int dif = INT_MAX;
        // int res = INT_MAX;
        int ans = INT_MAX;
        for(int i=0;i<n;i++){
            // cout<<arr1[i]<<" "<<arr2[i]<<endl;
            if(arr1[i]!=INT_MAX  && arr2[i]!=INT_MAX){
                // int temp = arr1[i]+arr2[i];
                if(dif>max(arr1[i],arr2[i])){
                    // res = temp;
                    ans = i;
                    dif = max(arr1[i],arr2[i]);
                }
            }
        }
        if(ans==INT_MAX)    return -1;
        return ans;
    }
};