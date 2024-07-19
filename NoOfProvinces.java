/*
Number of Provinces
Difficulty: MediumAccuracy: 54.29%Submissions: 104K+Points: 4

Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.

Example 2:

Input:
[
 [1, 1],
 [1, 1]
]

Output :
1


Your Task:  
You don't need to read input or print anything. Your task is to complete the function numProvinces() which takes an integer V and an adjacency matrix adj(as a 2d vector) as input and returns the number of provinces. adj[i][j] = 1, if nodes i and j are connected and adj[i][j] = 0, if not connected.


Expected Time Complexity: O(V2)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V ≤ 500
*/

class Solution {
    // private static int count =0 ;
    public static int  bfs(ArrayList<ArrayList<Integer>> adj,int i,boolean visited[]){
        Queue<Integer> a = new LinkedList<>();
        a.add(i);
        // count++;
        visited[i] = true;
        while(!a.isEmpty()){
            int temp = a.poll();
            for(int j=0;j<adj.get(temp).size();j++){
                if(adj.get(temp).get(j)==1 && !visited[j]){
                    a.add(j);
                    visited[j] = true;
                }
            }
        }
        return 1;
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean [] visited = new boolean[V];
        int res=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
              res+=bfs(adj,i,visited);
            }
        }
        return res;
        // code here
    }
};
