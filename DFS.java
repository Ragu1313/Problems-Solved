package org.example;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int vertices;
    static LinkedList<Integer>[] adj ;
    Graph(int vertices){
        this.vertices=vertices;
        adj=new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            adj[i] =new LinkedList<>();
        }
    }
    public void addEdge(int value1,int value2){
        adj[value1].add(value2);
    }
    public static void dfs(int value, boolean[] visited){
        visited[value]=true;
        System.out.println(value);
        Iterator<Integer> a = adj[value].listIterator();
        while(a.hasNext()){
            int temp = a.next();
            if(!visited[temp]){
                dfs(temp,visited);
            }
        }
    }
    public static void main(String[] args){
//        try{
            int noofvertex = 4;
            boolean[] visited = new boolean[noofvertex];
            Graph graph = new Graph(noofvertex);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 0);
            graph.addEdge(2, 3);
            graph.addEdge(3, 3);
            int i;
            dfs(2,visited);
    }
}


