class Solution {
    int ans[] = new int[1];
    public int f(int src,List<List<Integer>> adj,int n,int[] vis){
        // int vis[] = new int[n];
        vis[src] = 1;
        int res1 = 0;
        int res2 = 0;
        for(int i : adj.get(src)){
            if(vis[i]==0)
            {
                // vis[i] = 1;
                int temp = 1 + f(i,adj,n,vis);
                if(res1<=temp){
                    res2 = res1;
                    res1 = temp;
                }
                else if(res2<temp){
                    res2 = temp;
                }
            }
        }
        // vis[src] = 0;
        ans[0] = Math.max(ans[0],res1+res2);
        // System.out.println(src +" "+res1+" "+res2);
        return res1;
    }
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int vis[] = new int[V];
        vis[0] = 1;
        f(0,adj,V,vis);
        return ans[0];
    }
    
}