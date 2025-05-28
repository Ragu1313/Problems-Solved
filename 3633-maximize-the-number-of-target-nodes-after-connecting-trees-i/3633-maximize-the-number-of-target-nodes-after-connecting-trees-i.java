class Solution {

    public int f(List<List<Integer>> adj,int k){
        if(k<=0)   return 0;
        int n = adj.size();
        
        int vis[] = new int[n];
        // int cnt = 1;
        int res = 0;
        int dup = k-1;
        
        for(int i=0;i<n;i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = 1;
            int cnt = 1;
            k = dup;
            while(!q.isEmpty() && k-->0){
                int size = q.size();
                while(size-->0){
                    int temp = q.poll();
                    for(int j : adj.get(temp)){
                        if(vis[j]==0){
                            cnt++;
                            vis[j] = 1;
                            q.add(j);
                        }
                    }
                }
            }
            Arrays.fill(vis,0);
            res = Math.max(res,cnt);
        }
        return res;
    }

    public int f1(int i,List<List<Integer>> adj,int k){
        // if(k==-1)
        int n = adj.size();
        int vis[] = new int[n];
        vis[i] = 1;
        // int res = 0;
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty() && k-->0){
            int size = q.size();
            while(size-->0){
                int temp = q.poll();
                for(int j : adj.get(temp)){
                    if(vis[j]==0){
                        cnt++;
                        // System.out.println(j);
                        vis[j] = 1;
                        q.add(j);
                    }
                }
            }
            
        }
        return cnt;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        int n = edges1.length;
        int m = edges2.length;
        for(int i=0;i<=n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<=m;i++){
            adj2.add(new ArrayList<>());
        }
        for(int i[] : edges1){
            adj1.get(i[0]).add(i[1]);
            adj1.get(i[1]).add(i[0]);
        }
        for(int i[] : edges2){
            adj2.get(i[0]).add(i[1]);
            adj2.get(i[1]).add(i[0]);
        }
        int atleast = f(adj2,k);
        // System.out.println(atleast);
        int res[] = new int[n+1];

        for(int i=0;i<=n;i++){
            int temp = f1(i,adj1,k)+atleast;
            res[i] = temp;
        }
        return res;
    }
}