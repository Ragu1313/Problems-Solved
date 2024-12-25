class Solution {
    public void f(int src,int des,List<List<Integer>> adj,List<Integer> p,int [][]graph){
        p.add(src);
        if(src==des){
            adj.add(new ArrayList<>(p));
            p.remove(p.size()-1);
            return ;
        }
        for(int i=0;i<graph[src].length;i++){
            f(graph[src][i],des,adj,p,graph);
        }
        p.remove(p.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int src = 0;
        int des = n-1;
        f(src,des,adj,new ArrayList<>(),graph);
        return adj;
    }
}