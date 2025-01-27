class Solution {
    int res = -1;
    public void f(int v,int edge[],int vis[],int par[],int p){
        vis[v] = 1;
        par[v] = p;
        // System.out.println(v+" "+p);
        if(edge[v]==-1 ){
            vis[v] = 2;
            return ;
        }
        if(vis[edge[v]]==1){
            // System.out.println(v+" "+p);
            int temp = 1;
            p = v;
            while(edge[v] != p){
                p = par[p];
                temp++;
            }
            if(edge[v]==p)
            res = Math.max(res,temp);
        }
        else if(vis[edge[v]]==0){
            f(edge[v],edge,vis,par,v);
        }
        vis[v] = 2;
    }
    public int longestCycle(int[] edges) {
        res = -1;
        Map<Integer,Integer> map = new HashMap<>();
        int n = edges.length;
        int v[] = new int[n];
        int par[] = new int[n];
        for(int i=0;i<n;i++){
            if(v[i]==0){
                f(i,edges,v,par,-1);
            }
        }
        return res;
    }
}