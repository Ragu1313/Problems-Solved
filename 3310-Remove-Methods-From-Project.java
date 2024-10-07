class Solution {
    public void bfs(int v,int visited[],int affected[],ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 1;
        affected[v] = 1;
        while(!q.isEmpty()){
            int edge = q.poll();
            ArrayList<Integer> arr = adj.get(edge);
            for(int n : arr){
                if(visited[n]==-1){
                    q.add(n);
                    affected[n] = 1;
                    visited[n] = 1;
                }
            }    
        }
    }
    public void bfs1(int v,int visited[],int affected[],ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        affected[v] = 0;
        q.add(v);
        while(!q.isEmpty()){
            int edge = q.poll();
            ArrayList<Integer> arr = adj.get(edge);
            for(int i:arr){
                if(affected[i]==1){
                    q.add(i);
                    affected[i] = 0;
                }
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] egde) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)    
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<egde.length;i++){
            adj.get(egde[i][0]).add(egde[i][1]);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int visited[] = new int[n];
        Arrays.fill(visited,-1);
        int affected[] = new int[n];
        bfs(k,visited,affected,adj);
        for(int i=0;i<egde.length;i++){
           adj.get(egde[i][1]).add(egde[i][0]);
        }
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                bfs1(i,visited,affected,adj);
            }
        }
        for(int i=0;i<n;i++)   {
            if(affected[i]==0)  res.add(i);
            else if(affected[i]==1){
                ArrayList<Integer> arr = adj.get(i);
                for(int j : arr){
                    if(affected[j]==0)  {
                        res.add(i);
                        break;
                    }
                }
            }
        }
        return res;
    }
}