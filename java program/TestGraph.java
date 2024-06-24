import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
    public Graph(int n){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEgde(int v,int u){
        if(v!=u)
        adj.get(v).add(u);
        adj.get(u).add(v);
    }
    public void display(){
        for (int i=0;i<adj.size();i++){
            System.out.println("Edge "+ i+" adjacent");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    void bfs(int x){
       int adsize = adj.size();
       boolean [] a = new boolean[adsize];
       Queue<Integer> bf = new LinkedList<>();
       bf.add(x);
       a[x] = true;
       while(bf.size()!=0){
           int vertex = bf.remove();
           System.out.print(vertex +" ");
           for(int i=0;i<adj.get(vertex).size();i++){
              int visited = adj.get(vertex).get(i); 
              if(a[visited] == false){
                bf.add(visited);
                a[visited] = true;
              }
           }
       }
       System.out.println();
    }
    void dfs(int v){
        int dfssize = adj.size();
        boolean [] a = new boolean[dfssize];
        dfs2(v, a);
    }
    void dfs2(int v,boolean []a){
        a[v] = true;
        System.out.print(v+" ");
        for(int i=0;i<adj.get(v).size();i++){
            int visited = adj.get(v).get(i);
            if(!a[visited]){
                a[visited] = true;
                dfs2(visited,a);
            }
        }

    }

}
public class TestGraph {
    public static void main(String[] args) {
        int [][] graph = {
            {1,1,0,0,1},
            {1,0,0,0,0} ,
            {0,0,1,1,0},
            {0,0,1,1,1}   ,
            {1,1,0,1}   ,    
        };
        Graph l = new Graph(5);
        l.addEgde(1, 1);
        l.addEgde(1, 4);
        l.addEgde(2, 1);
        l.addEgde(2, 4);
        l.addEgde(3, 3);
        l.addEgde(3, 4);
        l.addEgde(4, 4);
        l.addEgde(0, 4);
        l.addEgde(0, 1);
        l.display();
        l.bfs(1);
        l.dfs(1);
        close(graph);
    }

    private static void close(int[][] graph) {
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
}
