class Solution {
    public int helper(Queue<Integer> q ,int in[],List<List<Integer>> adj,int out[]){
        int res = 0;
        int vertex = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            res += vertex - out[temp];
            vertex++;
            for(int i : adj.get(temp)){
                in[i]--;
                if(in[i]==0){
                    q.add(i);
                }
            }
        }
        return res;
    }
    public int maxEdgesToAdd(int V, int[][] edges) {
        int in[] = new int[V];
        int out[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            in[i[1]]++;
            out[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(in[i]==0){
                q.add(i);
                // break;
            }
        }
        return helper(q,in,adj,out)  ;      
    }
}