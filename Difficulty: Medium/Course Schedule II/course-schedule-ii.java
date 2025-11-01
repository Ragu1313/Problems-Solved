class Solution {
    public void f(Queue<Integer> q,ArrayList<Integer> res,int in[],List<List<Integer>> adj,int vis[]){
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i : adj.get(temp)){
                in[i]--;
                if(in[i]==0 && vis[i]==0){
                    q.add(i);
                    res.add(i);
                    vis[i] = 1;
                }
            }
        }
        return ;
    }
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        int in[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : prerequisites){
            adj.get(i[1]).add(i[0]);
            in[i[0]]++;
        }
        int vis[] = new int[n];
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0 && vis[i]==0){
                q.add(i);
                res.add(i);
                vis[i] = 1;
                f(q,res,in,adj,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(in[i]>0) return new ArrayList<>();
        }
        // System.out.println(res);
        return res;
    }
}