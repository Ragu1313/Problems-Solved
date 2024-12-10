class Solution {

    public int f(int v,int n,int vis[],List<List<Integer>> adj){
        // int v = conn[0][0];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = 1;
        int c = 0;
        while(!q.isEmpty()){
            v = q.poll();
            for(int i : adj.get(v)){
                if(vis[i]==0){
                    q.add(i);
                    c++;
                    vis[i] = 1;
                }
            } 
        }
        return c;
    }
    public int makeConnected(int n, int[][] con) {
        int vis[] = new int[n];
        List<List<Integer> > arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<con.length;i++){
            arr.get(con[i][0]).add(con[i][1]);
            arr.get(con[i][1]).add(con[i][0]);
        }
        int connection = con.length;
        int res = 0;
        int cc=0;
        for(int i=0;i<arr.size();i++){
            if(vis[i]==0 && arr.get(i).size()>0){
                cc++;
               res = res+ f(i,n,vis,arr);
            }
        }
        cc--;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0)
            cnt++;
        }
        // System.out.println(res+cnt);
        if(connection<res+cnt+cc){
            return -1;
        }
        else{
            return cnt+cc;
        }
    }
}