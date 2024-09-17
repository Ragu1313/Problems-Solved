/*
Number of Distinct Islands
Difficulty: MediumAccuracy: 62.29%Submissions: 81K+Points: 4
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task:

You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1
*/

class Solution {
    String toString(int i,int j){
        return String.valueOf(i)+""+String.valueOf(j);
    }
    void bfs(int curi,int curj,int [][]grid,int [][] visited,
    ArrayList<String> p,int i,int j){
        int n1 = grid.length;
        int m1 = grid[0].length;
        visited[curi][curj] = 1;
        
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{curi,curj});
        int v1[] = new int[]{0,1,0,-1};
        int v2[] = new int[]{1,0,-1,0};
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int i1 = arr[0];
            int j1 = arr[1];
            p.add(toString(i1-i,j1-j));
            for(int k=0;k<4;k++){
                int n = i1+v1[k];
                int m = j1+v2[k];
                if(n>=0 && n<n1 && m>=0 && m<m1 && visited[n][m]==0 && 
                grid[n][m]==1){
                    q.add(new int[]{n,m});
                    visited[n][m] = 1;
                }
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        HashSet<ArrayList<String>> res = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ArrayList<String> p = new ArrayList<>();
                    bfs(i,j,grid,visited,p,i,j);
                    res.add(p);
                }
            }
        }
        return res.size();
    }
}
