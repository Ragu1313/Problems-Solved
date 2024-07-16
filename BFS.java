import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
    public BFS(int vertices){
        for(int i=0;i<vertices;i++){
            adj.add(new LinkedList<>());
        }
    }
    public void addEdge(int v,int u){
        adj.get(v).add(u);
    }
    public void bfs(int value,boolean[] visited){
//        visited[value] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(value);
        visited[value] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.println(temp);
            for(int i:adj.get(temp)){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        boolean visited [] = new boolean[vertices];
        BFS bfs = new BFS(vertices);
        bfs.addEdge(0, 1); // A -> B
        bfs.addEdge(0, 2); // A -> C
        bfs.addEdge(1, 0); // B -> A
        bfs.addEdge(1, 3); // B -> D
        bfs.addEdge(2, 0); // C -> A
        bfs.addEdge(2, 4); // C -> E
        bfs.addEdge(3, 1); // D -> B
        bfs.addEdge(3, 4); // D -> E
        bfs.addEdge(4, 2); // E -> C
        bfs.addEdge(4, 3); // E -> D
        bfs.bfs(0,visited);
    }

}
