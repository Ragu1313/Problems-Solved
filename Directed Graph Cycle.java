/*
Directed Graph Cycle
Difficulty: MediumAccuracy: 27.88%Submissions: 411K+Points: 4
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.
In the adjacency list adj, element adj[i][j] represents an edge from i to j.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
*/


class Solution {
    // Function to detect cycle in a directed graph.
    private boolean res = false;
    public void dfs(int v,int pathVis[],int vis[],
    ArrayList<ArrayList<Integer>> adj){
        pathVis[v] = 1;
        vis[v] = 1;
        for(int i : adj.get(v)){
            if(vis[i]==0){
                dfs(i,pathVis,vis,adj);
            }
            else if(vis[i]==1 && pathVis[i]==1){
                res = true;
                return;
            }
        }
        pathVis[v]=0;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        res = false;
        int pathVis[] = new int[V];
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,pathVis,vis,adj);
                if(res) return true;
            }
        }
        return false;
    }
}
