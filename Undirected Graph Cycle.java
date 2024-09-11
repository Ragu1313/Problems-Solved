/*
Undirected Graph Cycle
Difficulty: MediumAccuracy: 30.13%Submissions: 455K+Points: 4
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

Examples:

Input: V = 5, E = 5
adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]] 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
 

Input: V = 4, E = 2
adj = [[], [2], [1, 3], [2]]
Output: 0
Explanation: 

No cycle in the graph.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V) 

Constraints:
1 ≤ V, E ≤ 105
*/

class Solution {
    public boolean bfs(int v,int [] visited,ArrayList<ArrayList<Integer>> adj){
        visited[v] = 1;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{v,-1});
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int child = temp[0];
            int parent = temp[1];
            ArrayList<Integer> adjacent = adj.get(child);
            for(int i=0;i<adjacent.size();i++){
                int element = adjacent.get(i);
                if(visited[element]!=1 ){
                    visited[element] = 1;
                    q.add(new int[]{element,child});
                }
                else if(element!=parent){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V];
        boolean t = false;
        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                t = bfs(i,visited,adj);
                if(t)   return true;
            }
        }
        return false;
    }
}
