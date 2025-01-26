class Solution {

    public int f(int v,int vis[],List<List<Integer>> adj,List<List<Integer>> dup){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i : dup.get(temp)){
                if(vis[i]==0){
                    q.add(i);
                    vis[i] = 1;
                    if(!adj.get(i).contains(temp))  cnt++;
                }
            }
        }
        return cnt;
    }    
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> dup = new ArrayList<>();
        int n1 = connections.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            dup.add(new ArrayList<>());
        }
        for(int i=0;i<n1;i++){
            int src = connections[i][0];
            int des = connections[i][1];
            adj.get(src).add(des);
            dup.get(src).add(des);
            dup.get(des).add(src);
        }    
        int vis[] = new int[n];
        return f(0,vis,adj,dup);
    }
}