class Solution {
   
    public int shortCycle(int V, int[][] edges) {
        int vis[] = new int[V];
        int par[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            Arrays.fill(vis,-1);
        }
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
            if(i[0]==i[1])  return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<V;i++){
            Arrays.fill(vis,-1);
            Arrays.fill(par,-2);
            int cnt = 1;
            par[i] = -1;
            vis[i] = 0;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i,-1});
            while(!q.isEmpty()){
                int size = q.size();
                while(size-->0){
                    int temp[] = q.poll();
                    int parent = temp[0];
                    for(int node : adj.get(temp[0])){
                        if(vis[node]==-1){
                            vis[node] = cnt;
                            par[node] = parent;
                            q.add(new int[]{node,parent});
                        }
                        else if(node != temp[1]){
                            int tot = cnt + vis[node] ;
                            // System.out.println(cnt+" "+vis[node]+" "+node);
                            res = Math.min(res,tot);
                        }
                    }
                }
                cnt++;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}