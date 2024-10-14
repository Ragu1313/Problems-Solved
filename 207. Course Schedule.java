/*

207. Course Schedule
Solved
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.*/


class Solution {
    public boolean res = true;
    public void bfs(int v,ArrayList<ArrayList<Integer>> adj,int visited[],int pathvis[]){
        // Queue<Integer> q = new LinkedList<>();
        // q.add(v);
        visited[v] = 1;
        pathvis[v] = 1;
        for(int i : adj.get(v)){
            if(pathvis[i]==0 && visited[i]==0)
            bfs(i,adj,visited,pathvis);
            else if(pathvis[i]==1 && visited[i]==1)
            {
                res = false;
                return;
            }
        }
        pathvis[v] = 0;
    }
    public boolean canFinish(int numCourses, int[][] nums) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int visited[] = new int[numCourses];
        int pathvis[] = new int[numCourses];
        for(int i=0;i<nums.length;i++){
            adj.get(nums[i][1]).add(nums[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                bfs(i,adj,visited,pathvis);
                if(!res)
                    return false;
            }
        }
        return res;
    }
}
